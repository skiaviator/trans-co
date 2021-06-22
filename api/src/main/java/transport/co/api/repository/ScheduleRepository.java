package transport.co.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import transport.co.api.model.Schedule;


@Repository
public interface ScheduleRepository extends JpaRepository<Schedule,Long> {


}
