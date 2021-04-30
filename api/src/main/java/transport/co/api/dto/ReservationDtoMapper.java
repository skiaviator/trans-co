//package transport.co.api.dto;
//
//
//import transport.co.api.model.Reservation;
//import transport.co.api.repository.RouteRepository;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class ReservationDtoMapper {
//
//    private static RouteRepository routeRepository;
//    private ReservationDtoMapper() {}
//
//    public static List<ReservationDto> mapToReservationDtos(List<Reservation> reservations){
//        return reservations.stream()
//                .map(reservation -> maptoReservationDto(reservation))
//                .collect(Collectors.toList());
//    }
//
//    private static ReservationDto maptoReservationDto(Reservation reservation) {
//        return ReservationDto.builder()
//                .id(reservation.getId())
//                .reservationNr(reservation.getReservationNr())
//                .reservationStatus(reservation.getReservationStatus())
//                .routeName(routeRepository.findById(reservation.getRoute_Id()).orElseThrow().getRouteName())
//                .fee(routeRepository.findById(reservation.getRoute_Id()).orElseThrow().getFee())
//                .build();
//    }
//}
