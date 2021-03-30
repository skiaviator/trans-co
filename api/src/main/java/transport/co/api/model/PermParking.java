package transport.co.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="perm_parking")
public class PermParking {

    @Id
    @GeneratedValue
    private long id;

    @OneToOne
    @JoinColumn(name="address_id",nullable=false)
    private Address address;

    private int maxPeople;

    @Column(nullable=false)
    private boolean areFreeSeats;

}
