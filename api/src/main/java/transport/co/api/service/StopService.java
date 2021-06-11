package transport.co.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import transport.co.api.model.Route;
import transport.co.api.model.Stop;
import transport.co.api.repository.StopRepository;
import transport.co.api.request.RouteRequest;
import transport.co.api.request.StopRequest;

import java.util.List;

@Service
public class StopService {

    private final StopRepository stopRepository;

    @Autowired
    public StopService(StopRepository stopRepository) {
        this.stopRepository = stopRepository;
    }

    public List<Stop> getStops() {
        return stopRepository.findAll();
    }
    public Stop getSingleStop(long id){
        return stopRepository.findById(id).orElseThrow();
    }

    public Stop addStop(StopRequest stopRequest) {
        Stop stop = new Stop(stopRequest);
        stopRepository.save(stop);
        return stop;
    }

}
