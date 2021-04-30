package transport.co.api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import transport.co.api.model.Route;
import transport.co.api.repository.RouteRepository;

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
}
