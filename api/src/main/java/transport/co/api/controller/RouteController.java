package transport.co.api.controller;

import io.swagger.models.Response;
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
    public ResponseEntity<List<RouteDto>> getRoutes(){
        return new ResponseEntity<>(RouteDto.fromList(routeService.getRoutes()),HttpStatus.OK);
    }

    @GetMapping("/routes/{id}")
    public ResponseEntity<RouteDto> getSingleRoute(@PathVariable Long id){
        return new ResponseEntity<>(RouteDto.from(routeService.getSingleRoute(id)),HttpStatus.OK);
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
    public ResponseEntity<RouteDto> editRoute(@RequestBody RouteDto routeDto){
        return new ResponseEntity<>(routeService.editRoute(routeDto),HttpStatus.OK);}

    @DeleteMapping("/routes")
    public ResponseEntity<Long> deleteRoute(@RequestParam Long routeId){
        boolean isRemoved = routeService.deleteRoute(routeId);

        if (!isRemoved) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(routeId, HttpStatus.OK);
    }

}
