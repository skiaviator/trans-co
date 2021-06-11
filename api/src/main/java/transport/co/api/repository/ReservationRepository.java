package transport.co.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import transport.co.api.dto.ReservationDto;
import transport.co.api.model.Reservation;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long> {

    @Query("select new transport.co.api.dto.ReservationDto(r.id,r.reservationNr,r.reservationStatus,r.route.routeName,r.route.fee,r.depart) " +
            "from Reservation r where customer.id = ?1")
    List<ReservationDto> findAllWithCustomObjectsByCustomerId(long id);
}
