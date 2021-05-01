package transport.co.api.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;
import transport.co.api.request.PersonRequest;
import transport.co.api.request.RouteRequest;

import javax.persistence.*;
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

    //dlugosc przejazdu

    //routeWDroogastrone

   @OneToMany(cascade = CascadeType.REMOVE,mappedBy = "route")
  // @JoinColumn(name = "route_id", updatable = false, insertable = false)
   private List<Reservation> reservation;

//    @OneToMany(cascade = CascadeType.REMOVE)
//    @JoinColumn(name = "route_id", updatable = false, insertable = false)
//    private List<Schedule> schedule;

    @ManyToMany
    @JoinTable(
            name = "route_stop",
            joinColumns = @JoinColumn(name = "route_id"),
            inverseJoinColumns = @JoinColumn(name = "stop_id"))
    private List<Stop> routeStops;

    public Route (RouteRequest routeRequest){
        this.fee=routeRequest.getFee();
        this.routeName=routeRequest.getRouteName();
    }
    public Route(){}

}
