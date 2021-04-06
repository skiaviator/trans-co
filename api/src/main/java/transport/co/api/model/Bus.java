package transport.co.api.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Table(name="buses")
public class Bus {

    @Id
    @GeneratedValue
    private long id;

    @OneToMany(mappedBy = "bus")
    private List<Schedule> schedule;

    @ManyToOne
    @JoinColumn(name="perm_parking_id",nullable=false)
    private PermParking permParking;

    @ManyToMany(mappedBy="drivedBuses")
    private List<Driver> drivers;

    private String busModel;

    private String mark;

    @Temporal(TemporalType.DATE)
    private Date prodDate;

    private String avFuelConsumption;

    private double mileage;

    @Column(nullable=false)
    private boolean availability;

    private int capacity;

}
