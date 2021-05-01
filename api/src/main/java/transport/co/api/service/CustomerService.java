package transport.co.api.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
//import transport.co.api.dto.ReservationDtoMapper;
import transport.co.api.model.Customer;
import transport.co.api.repository.CustomerRepository;
import transport.co.api.repository.ReservationRepository;
import transport.co.api.repository.RouteRepository;
import transport.co.api.request.PersonRequest;

import javax.transaction.Transactional;
import java.util.List;

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

    public Customer addCustomer(PersonRequest personRequest) {
        Customer customer=new Customer(personRequest);
        System.out.println(customer.getId());
        customerRepository.save(customer);
        return customer;
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
