package transport.co.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import transport.co.api.model.Address;
import transport.co.api.model.Employee;

@Repository
public interface EmployeeRepository extends PersonRepository<Employee,Long> {
}
