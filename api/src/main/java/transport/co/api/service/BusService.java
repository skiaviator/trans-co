package transport.co.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import transport.co.api.dto.BusDto;
import transport.co.api.dto.RouteDto;
import transport.co.api.model.Bus;
import transport.co.api.model.Route;
import transport.co.api.repository.BusRepository;
import transport.co.api.request.BusRequest;
import transport.co.api.request.StopRequest;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BusService {

    private final BusRepository busRepository;
    private final RouteService routeService;

    @Autowired
    public BusService(BusRepository busRepository,RouteService routeService) {
        this.busRepository = busRepository;
        this.routeService = routeService;
    }

    public List<Bus> getBuses() {
        return busRepository.findAll();
    }

    public Bus getSingleBus(Long busId) {
        return busRepository.findById(busId).orElseThrow();
    }

    public Bus addBus(BusRequest busRequest) {
        Bus bus = new Bus(busRequest);
        busRepository.save(bus);
        return bus;
    }

    @Transactional
    public BusDto editBus(BusDto busDto) {
        Bus busEdited = busRepository.findById(busDto.getId()).orElseThrow();
        busEdited.setAvailability(busDto.isAvailability());
        busEdited.setAvFuelConsumption(busDto.getAvFuelConsumption());
        busEdited.setBusModel(busDto.getBusModel());
        busEdited.setCapacity(busDto.getCapacity());
        busEdited.setId(busDto.getId());
        busEdited.setMark(busDto.getMark());
        busEdited.setProdDate(busDto.getProdDate());

        return BusDto.from(busEdited);
    }

    public boolean deleteBus(Long busId) {
        if(!ifExist(busId)) return false;
        busRepository.deleteById(busId);
        return true;
    }

    public boolean ifExist(Long busId){
        return busRepository.existsById(busId);
    }

    @Transactional
    public boolean assignRoute(Long busId, Long routeId) {
        if(!ifExist(busId)) return false;
        if(!routeService.ifExist(routeId)) return false;
        Bus bus= busRepository.findById(busId).orElseThrow();
        Route route = routeService.getSingleRoute(routeId);
        bus.setRoute(route);
        route.getBuses().add(bus);
        return true;
    }

    @Transactional
    public boolean dismissRoute(Long busId) {
        if(!ifExist(busId)) return false;
        Bus bus=busRepository.findById(busId).orElseThrow();
        if(!routeService.ifExist(bus.getRoute().getId()) || bus.getRoute()==null) return false;
        Route route = routeService.getSingleRoute(bus.getRoute().getId());
        bus.setRoute(null);
        route.getBuses().remove(bus);
        return true;
    }
}
