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
        // Page<Reservation> reservationPage = customerRepository.findById(id,pageReq).get(id).getReservations();
//        Page<Reservation> reservationsPage = new PageImpl<Reservation>(
//                customerRepository.findById(id).get().getReservations(),
//               pageReq,customerRepository.findById(id).get()
//                .getReservations().size());
        // List<Reservation> userReservations = customerRepository.findById(id).orElseThrow().getReservations();
        // List<Long> ids = userReservations.stream()
        //      .map(Reservation::getRoute_Id)
        //       .collect(Collectors.toList());
        //  List<Route> routes = routeRepository.findAllBy
        //  List<Route> userRoutes = routeRepository.findAllById(ids);
        //   userReservations.forEach(reservation -> routeRepository.findById(reservation.getRoute_Id()).orElseThrow().getRouteName());
//        List<ReservationDto> reservationDtos = new ArrayList<>(userReservations.size());
//        for(int i=0;i<userReservations.size();i++){
//            reservationDtos.get(i).setId(userReservations.get(i).getId());
//            reservationDtos.get(i).setReservationNr(userReservations.get(i).getReservationNr());
//            reservationDtos.get(i).setReservationStatus(userReservations.get(i).getReservationStatus());
//            reservationDtos.get(i).setFee(routeRepository.findById(ids.get(i)).orElseThrow().getFee());
//            reservationDtos.get(i).setRouteName(routeRepository.findById(ids.get(i)).orElseThrow().getRouteName());
//        }
        //  return ReservationDtoMapper.mapToReservationDtos(userReservations);
        return reservationRepository.findAllWithCustomObjectsByCustomerId(id);

    }

    public Reservation addReservation(ReservationRequest reservationRequest) {
        Reservation reservation = new Reservation(customerService.getSingleCustomer(reservationRequest.getCustomerId()),
                routeService.getSingleRoute(reservationRequest.getRouteId()),
                scheduleService.getSingleSchedule(reservationRequest.getScheduleId()).getDepart(),
                ReservationStatus.toBeRealized,12);
       return reservationRepository.save(reservation);

    }
    //private assignReservationNr
}
