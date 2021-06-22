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

    @GetMapping("/customers")
    public ResponseEntity<List<CustomerDto>> getCustomers(){
        return new ResponseEntity<>(CustomerDto.fromList(customerService.getCustomers()),HttpStatus.OK);
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<CustomerDto> getSingleCustomer(@PathVariable Long id){
        return new ResponseEntity<>(CustomerDto.from(customerService.getSingleCustomer(id)),HttpStatus.OK);}

    @PostMapping("/customers")
    public ResponseEntity<CustomerDto> addCustomer(@RequestBody PersonRequest personRequest){
        Customer customer=customerService.addCustomer(personRequest);
        return new ResponseEntity<>(CustomerDto.from(customer),HttpStatus.OK);
    }


    @PutMapping("/customers")
    public ResponseEntity<CustomerDto> editCustomer(@RequestBody CustomerDto customerDto){
        return new ResponseEntity<>(customerService.editCustomer(customerDto),HttpStatus.OK);}

    @DeleteMapping("/customers")
    public ResponseEntity<Long> deleteCustomer(@RequestParam Long customerId){
        boolean isRemoved = customerService.deleteCustomer(customerId);

        if (!isRemoved) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(customerId, HttpStatus.OK);
    }


}


