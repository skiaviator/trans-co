package transport.co.api.model;

import lombok.Getter;
import lombok.Setter;
import transport.co.api.logic.ReservationStatus;

import javax.persistence.*;
import java.util.Date;

@Entity
@Setter
@Getter
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reservation_generator")
    @SequenceGenerator(name="reservation_generator", sequenceName = "reservation_seq")
    private long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "route_id")
    private Route route;

    private Date depart;

    private int reservationNr;



    @Enumerated(EnumType.STRING)
    private ReservationStatus reservationStatus = ReservationStatus.toBeRealized;

    public Reservation(){}
    public Reservation(Customer customer, Route route, Date depart, ReservationStatus reservationStatus, int reservationNr){
        this.customer=customer;
        this.route=route;
        this.reservationNr=reservationNr;
        this.reservationStatus=reservationStatus;
        this.depart=depart;
    }

}
