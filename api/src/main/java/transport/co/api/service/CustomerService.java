package transport.co.api.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import transport.co.api.dto.ReservationDto;
//import transport.co.api.dto.ReservationDtoMapper;
import transport.co.api.model.Customer;
import transport.co.api.model.Reservation;
import transport.co.api.model.Route;
import transport.co.api.repository.CustomerRepository;
import transport.co.api.repository.ReservationRepository;
import transport.co.api.repository.RouteRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final ReservationRepository reservationRepository;
    private final CustomerRepository customerRepository;
    private final RouteRepository routeRepository;
    private final ModelMapper modelMapper;
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public Customer getSingleCustomer(long id) {
        return customerRepository.findById(id).orElseThrow();
    }

    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }


    @Transactional
    public Customer editCustomer(Customer customer) {
        Customer customerEdited = customerRepository.findById(customer.getId()).orElseThrow();
        customerEdited.setAddress(customer.getAddress());
        customerEdited.setBirthdate(customer.getBirthdate());
        customerEdited.setEmail(customer.getEmail());
        customerEdited.setFirstname(customer.getFirstname());
        customerEdited.setSurname(customer.getSurname());
        customerEdited.setPhonenr(customer.getPhonenr());
        return customerEdited;
    }

    public void deleteCustomer(long id) {
        customerRepository.deleteById(id);
    }





}
