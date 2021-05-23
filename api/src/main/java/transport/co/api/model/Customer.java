package transport.co.api.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;
import transport.co.api.request.PersonRequest;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "customers")
public class Customer extends Person {


    private int points;
    private int notrealized;

    @OneToMany(cascade = CascadeType.REMOVE,mappedBy = "customer")
    private List<Reservation> reservations = new ArrayList<>();

    public Customer(){}
    public Customer (PersonRequest personRequest){
    super(personRequest);
    }

    public void addReservation(Reservation reservation){
        reservations.add(reservation);
    }
}
