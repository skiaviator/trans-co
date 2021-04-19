package transport.co.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import transport.co.api.model.Address;
import transport.co.api.model.Customer;

@Repository
public interface CustomerRepository extends PersonRepository<Customer,Long> {
}
