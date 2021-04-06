package transport.co.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="drivers")
public class Driver extends Person{


    @ManyToMany
    @JoinTable(
            name = "driver_bus",
            joinColumns = @JoinColumn(name = "driver_id"),
            inverseJoinColumns = @JoinColumn(name = "bus_id"))
    private List<Bus> drivedBuses;

}
