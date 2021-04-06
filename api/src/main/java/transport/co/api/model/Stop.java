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
    @GeneratedValue
    private long id;

    @OneToOne(mappedBy= "nextStop", cascade = CascadeType.ALL)
    private Stop prevStop;

    @OneToOne
    private Stop nextStop;

    @ManyToMany(mappedBy="routeStops")
    private List<Route> routes;

}
