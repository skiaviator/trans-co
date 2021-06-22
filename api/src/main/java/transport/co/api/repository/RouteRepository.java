package transport.co.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import transport.co.api.model.Route;

@Repository
public interface RouteRepository extends JpaRepository<Route,Long> {
}
