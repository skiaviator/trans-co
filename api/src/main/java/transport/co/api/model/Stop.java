package transport.co.api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Table(name = "stops")
public class Stop {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "route_generator")
    @SequenceGenerator(name="route_generator", sequenceName = "route_seq")
    private long id;

//    @OneToOne(mappedBy= "nextStop", cascade = CascadeType.ALL)
//    @Column(nullable = true)
//    private Stop prevStop;
//
//    @OneToOne
//    @Column(nullable = true)
//    private Stop nextStop;
//
    @ManyToMany(mappedBy="routeStops")
    private List<Route> routes;

    @OneToMany(cascade = CascadeType.REMOVE,mappedBy = "stop")
    private List<Schedule> schedule;

}
