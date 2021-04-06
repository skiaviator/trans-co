package transport.co.api.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Getter
@Setter
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Table(name="schedules")
public class Schedule {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name="route_id",nullable=false)
    private Route route;

    @ManyToOne
    @JoinColumn(name="bus_id",nullable=false)
    private Bus bus;

    private Time arrive;

    private Time depart;
}
