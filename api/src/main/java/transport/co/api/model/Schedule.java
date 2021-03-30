package transport.co.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Getter
@Setter
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
