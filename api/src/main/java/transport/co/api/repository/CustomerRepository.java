package transport.co.api.repository;

import org.springframework.stereotype.Repository;
import transport.co.api.model.Customer;

@Repository
public interface CustomerRepository extends PersonRepository<Customer,Long> {
    //List<Customer> findById(long id, Pageable pageable);
    Customer findByEmail(String email);
}
