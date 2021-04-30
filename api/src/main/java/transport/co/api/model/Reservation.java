package transport.co.api.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
    @GeneratedValue
    private long id;
   // private long route_Id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "route_id")
    private Route route;

    private Date depart;

    private int reservationNr;



   // @Column(nullable=false, columnDefinition = "default 'toBeRealized'")
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
