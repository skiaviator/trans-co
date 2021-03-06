package transport.co.api.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;
import transport.co.api.request.PersonRequest;

import javax.persistence.*;

@Entity
@Getter
@Setter
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Table(name="drivers")
public class Driver extends Person{

private Double salary;
//    @ManyToMany
//    @JoinTable(
//            name = "driver_bus",
//            joinColumns = @JoinColumn(name = "driver_id"),
//            inverseJoinColumns = @JoinColumn(name = "bus_id"))
//    private List<Bus> drivedBuses;

    @ManyToOne
    @JoinColumn(name = "bus_id")
    private Bus bus;

    public Driver() {
    }

    public Driver(PersonRequest personRequest){
        super(personRequest);
    }

}
