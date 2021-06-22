package transport.co.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import transport.co.api.dto.StopDto;
import transport.co.api.model.Stop;

import java.util.List;

@Repository
public interface StopRepository extends JpaRepository<Stop,Long> {
    Stop findByNameIs(String name);

    @Query("select new transport.co.api.dto.StopDto(s.id,s.name) " +
            "from Stop s")
    List<StopDto> findAllWithoutRoutes();
}


