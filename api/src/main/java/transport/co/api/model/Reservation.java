package transport.co.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name="customer_id",nullable=false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name="route_id",nullable=false)
    private Route route;

    private int reservationNr;

}
