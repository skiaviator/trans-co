package transport.co.api.repository;

import org.springframework.stereotype.Repository;
import transport.co.api.model.Driver;

@Repository
public interface DriverRepository extends PersonRepository<Driver,Long> {
}
