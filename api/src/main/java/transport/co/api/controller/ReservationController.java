package transport.co.api.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import transport.co.api.dto.CustomerDto;
import transport.co.api.dto.ReservationDto;
import transport.co.api.model.Reservation;
import transport.co.api.request.ReservationRequest;
import transport.co.api.service.ReservationService;

import java.util.List;

@RestController
public class ReservationController {

    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/reservations")
    public ResponseEntity<List<ReservationDto>> getReservations(){
        return new ResponseEntity<>(reservationService.getReservations(),HttpStatus.OK);
    }

    @GetMapping("/reservations/{id}")
    public ResponseEntity<List<ReservationDto>> getCustomerReservationsWithRoutes(@PathVariable Long id){
        return new ResponseEntity<>(reservationService.getCustomerReservationsWithRoutes(id), HttpStatus.OK);}

    @PostMapping("/reservations")
    public ResponseEntity<ReservationDto> addReservation(@RequestBody ReservationRequest reservationRequest){
        Reservation reservation = reservationService.addReservation(reservationRequest);
        return new ResponseEntity<>(ReservationDto.from(reservation), HttpStatus.OK);
    }

    @PutMapping("/reservations")
    public ResponseEntity<ReservationDto> editReservation(@RequestBody ReservationDto reservationDto){
        return new ResponseEntity<>(reservationService.editReservation(reservationDto),HttpStatus.OK);}

    @DeleteMapping("/reservations")
    public ResponseEntity<Long> deleteReservation(@RequestParam Long reservationId){
        boolean isRemoved = reservationService.deleteCustomer(reservationId);

        if (!isRemoved) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(reservationId, HttpStatus.OK);
    }
}
