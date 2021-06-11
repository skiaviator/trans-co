package transport.co.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name="schedules")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "route_generator")
    @SequenceGenerator(name="route_generator", sequenceName = "route_seq")
    private long id;

    @ManyToOne
    @JoinColumn(name = "stop_id")
    private Stop stop;

    @ManyToOne
    @JoinColumn(name = "bus_id")
    private Bus bus;


    //private Time arrive;

    private Date depart;
}
