package transport.co.api.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import transport.co.api.logic.ReservationStatus;
import transport.co.api.model.Reservation;

import java.util.ArrayList;
import java.util.Date;

import java.util.List;
import java.util.stream.Collectors;


@Setter
@Getter
public class ReservationDto {

    private long id;
    private int reservationNr;
    private ReservationStatus reservationStatus;
    private String routeName;
    private float fee;
    private Date depart;

    public ReservationDto(long id,int reservationNr, ReservationStatus reservationStatus, String routeName, float fee, Date depart) {
        this.id=id;
        this.reservationNr = reservationNr;
        this.reservationStatus = reservationStatus;
        this.routeName = routeName;
        this.fee = fee;
        this.depart=depart;
    }
    private ReservationDto(Reservation reservation){
        this.id=reservation.getId();
        this.reservationNr=reservation.getReservationNr();
        this.reservationStatus=reservation.getReservationStatus();
        this.depart=reservation.getDepart();
        this.routeName=reservation.getRoute().getRouteName();
        this.fee=reservation.getRoute().getFee();
    }

    public ReservationDto(){}
    public static ReservationDto from(Reservation reservation){
        ReservationDto reservationDto= new ReservationDto();
        reservationDto.setId(reservation.getId());
        reservationDto.setReservationNr(reservation.getReservationNr());
        reservationDto.setReservationStatus(reservation.getReservationStatus());
        reservationDto.setDepart(reservation.getDepart());
        reservationDto.setRouteName(reservation.getRoute().getRouteName());
        reservationDto.setFee(reservation.getRoute().getFee());

        return reservationDto;
    }
    public static List<ReservationDto> fromList(List<Reservation> reservations){
       // List<ReservationDto> reservationDtos = new ArrayList<>();
        List<ReservationDto> reservationDtos = reservations.stream()
                .map(reservation -> new ReservationDto(reservation))
                .collect(Collectors.toList());
        return reservationDtos;
    }
}
