package transport.co.api.model;

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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "permparking_generator")
    @SequenceGenerator(name="permparking_generator", sequenceName = "permparking_seq")
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
