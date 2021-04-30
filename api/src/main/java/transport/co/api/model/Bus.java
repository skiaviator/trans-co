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
@Table(name="buses")
public class Bus {

    @Id
    @GeneratedValue
    private long id;

    @OneToMany(cascade = CascadeType.REMOVE,mappedBy = "bus")
    private List<Schedule> schedule;

    @ManyToOne
    private PermParking permParking;

//    @ManyToMany(mappedBy="drivedBuses")
//    private List<Driver> drivers;

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
