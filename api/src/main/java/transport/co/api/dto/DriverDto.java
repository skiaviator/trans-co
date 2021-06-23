package transport.co.api.dto;

import lombok.Data;
import transport.co.api.model.Customer;
import transport.co.api.model.Driver;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class DriverDto extends PersonDto{

    public DriverDto(Double salary) {
      this.salary=salary;
    }

    private Double salary;

    private BusDto busDto;

    private DriverDto(){}
    public static DriverDto from(Driver driver){
        DriverDto driverDto = new DriverDto();
        if(driver.getBus()!=null) driverDto.setBusDto(BusDto.from(driver.getBus()));
        driverDto.setId(driver.getId());
        driverDto.setFirstname(driver.getFirstname());
        driverDto.setSurname(driver.getSurname());
        driverDto.setBirthdate(driver.getBirthdate());
        driverDto.setEmail(driver.getEmail());
        driverDto.setPhonenr(driver.getPhonenr());
        driverDto.setSalary(driver.getSalary());

        driverDto.setAddressDto(AddressDto.from(driver.getAddress()));
        return driverDto;
    }

    public static List<DriverDto> fromList(List<Driver> drivers) {
        List<DriverDto> driverDtos = drivers.stream()
                .map(driver -> from(driver))
                .collect(Collectors.toList());
        return driverDtos;
    }
}
