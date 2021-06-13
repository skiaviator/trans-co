package transport.co.api.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;
import transport.co.api.request.StopRequest;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    private String name;

    @ManyToMany(mappedBy="routeStops")
    private List<Route> routes=new ArrayList<>();

   // @OneToMany(cascade = CascadeType.REMOVE,mappedBy = "stop")
   // private List<Schedule> schedule;

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "route_schedule_mapping",
//            joinColumns = {@JoinColumn(name = "stop_id", referencedColumnName = "id")},
//            inverseJoinColumns = {@JoinColumn(name = "schedule_id", referencedColumnName = "id")})
//    @MapKey(name = "depart")
//    private Map<String,Schedule> routeNameScheduleMap;

    public Stop (StopRequest stopRequest){
        this.name=stopRequest.getName();
    }

    public Stop(){
    }

}
