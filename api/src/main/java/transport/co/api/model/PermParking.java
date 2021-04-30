package transport.co.api.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="perm_parking")
public class PermParking {

    @Id
    @GeneratedValue
    private long id;

    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "perm_parking_id", updatable = false, insertable = false)
    private List<Bus> buses;

    @Embedded
    private Address address;

    private int maxPeople;

    @Column(nullable=false)
    private boolean areFreeSeats;

}
