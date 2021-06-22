package transport.co.api.repository;

import org.springframework.stereotype.Repository;
import transport.co.api.model.Customer;

@Repository
public interface CustomerRepository extends PersonRepository<Customer,Long> {
    Customer findByEmail(String email);
}
