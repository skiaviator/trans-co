package transport.co.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import transport.co.api.model.Customer;
import transport.co.api.model.Route;
import transport.co.api.service.RouteService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RouteController {

    private final RouteService routeService;

    @GetMapping("/routes")
    public List<Route> getRoutes(){
        return routeService.getRoutes();
    }


}
