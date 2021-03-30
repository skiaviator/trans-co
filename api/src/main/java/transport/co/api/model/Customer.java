package transport.co.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "customers")
public class Customer extends Person{

    private int points;
    private int notrealized;

    @OneToMany(mappedBy = "customer")
    private List<Reservation> reservations;
}
