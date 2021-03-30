package transport.co.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "routes")
public class Route {
    @Id
    @GeneratedValue
    private long id;

    private float fee;

    @OneToMany(mappedBy = "route")
    private List<Reservation> reservation;


    @OneToMany(mappedBy = "route")
    private List<Schedule> schedule;

    @ManyToMany
    @JoinTable(
            name = "route_stop",
            joinColumns = @JoinColumn(name = "route_id"),
            inverseJoinColumns = @JoinColumn(name = "stop_id"))
    private List<Stop> routeStops;

}
