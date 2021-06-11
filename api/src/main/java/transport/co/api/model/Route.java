package transport.co.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import transport.co.api.request.RouteRequest;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "routes")
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "route_generator")
    @SequenceGenerator(name="route_generator", sequenceName = "route_seq")
    private long id;

    private float fee;

    private String routeName;

    private String rideTime;


    //routeWDroogastrone
    @JsonIgnore
    @OneToMany(cascade = CascadeType.REMOVE,mappedBy = "route")
    private List<Reservation> reservation;


    @ManyToMany
    @JoinTable(
            name = "route_stop",
            joinColumns = @JoinColumn(name = "route_id"),
            inverseJoinColumns = @JoinColumn(name = "stop_id"))
    private List<Stop> routeStops=new ArrayList<>();

    public Route (RouteRequest routeRequest){
        this.fee=routeRequest.getFee();
        this.routeName=routeRequest.getRouteName();
    }
    public Route(){}

}
