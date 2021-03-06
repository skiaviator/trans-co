package transport.co.api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import transport.co.api.dto.DriverDto;
import transport.co.api.model.Address;
import transport.co.api.model.Bus;
import transport.co.api.model.Driver;
import transport.co.api.model.Route;
import transport.co.api.repository.AppUserRepository;
import transport.co.api.repository.DriverRepository;
import transport.co.api.request.PersonRequest;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class DriverService  {

    private final DriverRepository driverRepository;
    private final AppUserRepository appUserRepository;
    private final BusService busService;
    public List<Driver> getDrivers() {
        return driverRepository.findAll();
    }

    public Driver getSingleDriver(long id) {
        return driverRepository.findById(id).orElseThrow();
    }

    public Driver addDriver(PersonRequest personRequest) {
        Driver driver=new Driver(personRequest);
        driverRepository.save(driver);
        return driver;
    }


    @Transactional
    public DriverDto editDriver(DriverDto driverDto) {
        Driver driverEdited = driverRepository.findById(driverDto.getId()).orElseThrow();
        driverEdited.setAddress(Address.from(driverDto.getAddressDto()));
        driverEdited.setBirthdate(driverDto.getBirthdate());
        driverEdited.setEmail(driverDto.getEmail());
        driverEdited.setFirstname(driverDto.getFirstname());
        driverEdited.setSurname(driverDto.getSurname());
        driverEdited.setPhonenr(driverDto.getPhonenr());
        driverEdited.setSalary(driverDto.getSalary());
        return DriverDto.from(driverEdited);
    }

    public boolean deleteDriver(long driverId) {
        if(!ifExist(driverId)) return false;
        driverRepository.deleteById(driverId);
        return true;
    }


    public boolean ifExist(Long driverId){
        return driverRepository.existsById(driverId);
    }

    @Transactional
    public boolean assignBus(Long driverId, Long busId) {
        if(!ifExist(busId)) return false;
        if(!busService.ifExist(busId)) return false;
        Driver driver= driverRepository.findById(driverId).orElseThrow();
        Bus bus = busService.getSingleBus(busId);
        driver.setBus(bus);
        bus.getDrivers().add(driver);
        return true;
    }

    @Transactional
    public boolean dismissBus(Long driverId) {
        if(!ifExist(driverId)) return false;
        Driver driver=driverRepository.findById(driverId).orElseThrow();
        if(!busService.ifExist(driver.getBus().getId()) || driver.getBus()==null) return false;
        Bus bus = busService.getSingleBus(driver.getBus().getId());
        driver.setBus(null);
        bus.getDrivers().remove(driver);
        return true;
    }
}
