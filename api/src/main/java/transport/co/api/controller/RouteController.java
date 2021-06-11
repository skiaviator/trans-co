package transport.co.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import transport.co.api.dto.RouteDto;
import transport.co.api.model.Route;
import transport.co.api.request.RouteRequest;
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

    @PostMapping("/routes")
    public ResponseEntity<RouteDto> addRoute(@RequestBody RouteRequest routeRequest){
        Route route=routeService.addRouteWithStops(routeRequest);
        return new ResponseEntity<>(RouteDto.from(route), HttpStatus.OK);
      //  return new ResponseEntity<>(route,HttpStatus.OK);
    }
//    Reservation reservation = reservationService.addReservation(reservationRequest);
//        return new ResponseEntity<>(ReservationDto.from(reservation), HttpStatus.OK);
    @PutMapping("/routes")
    public RouteDto editRoute(@RequestBody RouteDto routeDto){ return routeService.editRoute(routeDto);}
}
