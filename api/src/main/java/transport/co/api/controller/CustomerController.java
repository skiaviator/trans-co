package transport.co.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import transport.co.api.dto.CustomerDto;
import transport.co.api.dto.ReservationDto;
import transport.co.api.model.Customer;
import transport.co.api.model.Reservation;
import transport.co.api.request.PersonRequest;
import transport.co.api.request.ReservationRequest;
import transport.co.api.service.CustomerService;
import transport.co.api.service.ReservationService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    private final ReservationService reservationService;


    @GetMapping("/customers")
    public List<Customer> getCustomers(){
        return customerService.getCustomers();
    }

    @GetMapping("/customers/{id}")
    public Customer getSingleCustomer(@PathVariable long id){ return customerService.getSingleCustomer(id);}

    @GetMapping("/customers/{id}/reservations")
    public List<ReservationDto> getCustomerReservationsWithRoutes(@PathVariable long id){ return reservationService.getCustomerReservationsWithRoutes(id);}

    @PostMapping("/customers")
    public ResponseEntity<CustomerDto> addCustomer(@RequestBody PersonRequest personRequest){
        Customer customer=customerService.addCustomer(personRequest);
        return new ResponseEntity<>(CustomerDto.from(customer),HttpStatus.OK);
    }

    @PostMapping("/customers/{id}/reservations")
    public ResponseEntity<ReservationDto> addReservation(@RequestBody ReservationRequest reservationRequest){
        Reservation reservation = reservationService.addReservation(reservationRequest);
        return new ResponseEntity<>(ReservationDto.from(reservation), HttpStatus.OK);
    }

    @PutMapping("/customers")
    public Customer editCustomer(@RequestBody Customer customer){ return customerService.editCustomer(customer);}

    @DeleteMapping("/customers/{id}")
    public void deleteCustomer(@PathVariable long id){customerService.deleteCustomer(id);}
}


