package transport.co.api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import transport.co.api.dto.ReservationDto;
import transport.co.api.logic.ReservationStatus;
import transport.co.api.model.Customer;
import transport.co.api.model.Reservation;
import transport.co.api.repository.ReservationRepository;
import transport.co.api.repository.RouteRepository;
import transport.co.api.request.ReservationRequest;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final RouteRepository routeRepository;
    private final CustomerService customerService;
    private final RouteService routeService;
    private final ScheduleService scheduleService;

    public List<ReservationDto> getCustomerReservationsWithRoutes(long id) {

        return reservationRepository.findAllWithCustomObjectsByCustomerId(id);

    }

    @Transactional
    public Reservation addReservation(ReservationRequest reservationRequest) {
        Customer customer = customerService.getSingleCustomer(reservationRequest.getCustomerIdd());
        Reservation reservation = new Reservation(customer,
                routeService.getSingleRoute(reservationRequest.getRouteIdd()),
                scheduleService.getSingleSchedule(reservationRequest.getScheduleIdd()).getDepart(),
                ReservationStatus.toBeRealized,12);
        customer.addReservation(reservation);
       return reservationRepository.save(reservation);

    }

}
