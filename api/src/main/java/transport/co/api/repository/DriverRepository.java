package transport.co.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import transport.co.api.model.Address;
import transport.co.api.model.Driver;

@Repository
public interface DriverRepository extends PersonRepository<Driver,Long> {
}
