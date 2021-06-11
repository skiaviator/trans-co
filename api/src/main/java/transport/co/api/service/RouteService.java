package transport.co.api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import transport.co.api.dto.RouteDto;
import transport.co.api.model.Route;
import transport.co.api.model.Stop;
import transport.co.api.repository.RouteRepository;
import transport.co.api.request.RouteRequest;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RouteService {
    private final RouteRepository routeRepository;
    private final StopService stopService;

    public List<Route> getRoutes() {
        return routeRepository.findAll();
    }
    public Route getSingleRoute(long id){
        return routeRepository.findById(id).orElseThrow();
    }

    @Transactional
    public Route addRouteWithStops(RouteRequest routeRequest) {
        Route route = new Route(routeRequest);
        route = routeRepository.save(route);
        List<Stop> stops;
        stops = stopService.addStopsWithRoute(routeRequest.getStopRequests(),route.getId());
        route.setRouteStops(stops);

        return route;
    }

    @Transactional
    public RouteDto editRoute(RouteDto routeDto) {
        Route routeEdited = routeRepository.findById(routeDto.getId()).orElseThrow();
        routeEdited.setRouteName(routeDto.getRouteName());
        routeEdited.setFee(routeDto.getFee());
        routeEdited.setRideTime(routeDto.getRideTime());
        routeEdited.setRouteStops(routeEdited.getRouteStops());
        return RouteDto.from(routeEdited);
    }
}
