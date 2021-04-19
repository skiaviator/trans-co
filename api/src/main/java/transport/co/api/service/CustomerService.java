package transport.co.api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import transport.co.api.model.Customer;
import transport.co.api.repository.CustomerRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }
}
