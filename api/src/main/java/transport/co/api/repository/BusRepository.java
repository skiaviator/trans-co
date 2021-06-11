package transport.co.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import transport.co.api.model.Bus;

@Repository
public interface BusRepository extends JpaRepository<Bus,Long> {
}
