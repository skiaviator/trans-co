package transport.co.api.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Table(name="perm_parking")
public class PermParking {

    @Id
    @GeneratedValue
    private long id;

    @Embedded
    private Address address;

    private int maxPeople;

    @Column(nullable=false)
    private boolean areFreeSeats;

}
