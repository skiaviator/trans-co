package transport.co.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import transport.co.api.dto.StopDto;
import transport.co.api.model.Stop;
import transport.co.api.repository.RouteRepository;
import transport.co.api.repository.StopRepository;
import transport.co.api.request.StopRequest;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class StopService {

    private final StopRepository stopRepository;
    private final RouteRepository routeRepository;

    @Autowired
    public StopService(StopRepository stopRepository,RouteRepository routeRepository) {
        this.stopRepository = stopRepository;
        this.routeRepository = routeRepository;
    }

    public List<StopDto> getStops() {
        return stopRepository.findAllWithoutRoutes();
    }
    public Stop getSingleStop(long id){
        return stopRepository.findById(id).orElseThrow();
    }

    @Transactional
    public Stop addStopWithRoute(StopRequest stopRequest,Long id) {
        Stop stop;
        if(stopRepository.findByNameIs(stopRequest.getName())==null) {
            stop = new Stop(stopRequest);
            stop.getRoutes().add(routeRepository.findById(id).orElseThrow());
            return stopRepository.save(stop);
        }
        else{
            stop = stopRepository.findByNameIs(stopRequest.getName());
            stop.getRoutes().add(routeRepository.findById(id).orElseThrow());
            return stop;
        }
    }
    public Stop addStop(StopRequest stopRequest) {
        Stop stop = new Stop(stopRequest);
        return stopRepository.save(stop);
    }
    public List<Stop> addStopsWithRoute(List<StopRequest> stopRequests,Long id) {

        List<Stop> stops= new ArrayList<>();
        for (StopRequest entity : stopRequests) {
           stops.add(addStopWithRoute(entity,id));
        }
        return stops;
    }

}
