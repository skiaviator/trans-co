package transport.co.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import transport.co.api.dto.CustomerDto;
import transport.co.api.dto.ReservationDto;
import transport.co.api.dto.RouteDto;
import transport.co.api.model.Customer;
import transport.co.api.model.Reservation;
import transport.co.api.model.Route;
import transport.co.api.request.PersonRequest;
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
        Route route=routeService.addRoute(routeRequest);
        return new ResponseEntity<>(RouteDto.from(route), HttpStatus.OK);
    }
//    Reservation reservation = reservationService.addReservation(reservationRequest);
//        return new ResponseEntity<>(ReservationDto.from(reservation), HttpStatus.OK);
}
