package transport.co.api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import transport.co.api.model.Route;
import transport.co.api.repository.RouteRepository;
import transport.co.api.request.RouteRequest;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RouteService {
    private final RouteRepository routeRepository;

    public List<Route> getRoutes() {
        return routeRepository.findAll();
    }
    public Route getSingleRoute(long id){
        return routeRepository.findById(id).orElseThrow();
    }

    public Route addRoute(RouteRequest routeRequest) {
        Route route = new Route(routeRequest);
        routeRepository.save(route);
        return route;
    }
}
