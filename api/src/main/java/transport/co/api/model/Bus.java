package transport.co.api.model;

import lombok.Getter;
import lombok.Setter;
import transport.co.api.request.BusRequest;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="buses")
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bus_generator")
    @SequenceGenerator(name="bus_generator", sequenceName = "bus_seq")
    private long id;

    @ManyToOne
    @JoinColumn(name = "route_id")
    private Route route;

   // @OneToMany(cascade = CascadeType.REMOVE,mappedBy = "bus")
   // private List<Schedule> schedule;

//    @ManyToMany(mappedBy="drivedBuses")
//    private List<Driver> drivers;

    @OneToMany(mappedBy="bus")
    private List<Driver> drivers=new ArrayList<>();

    private String busModel;

    private String mark;

    @Temporal(TemporalType.DATE)
    private Date prodDate;

    private String avFuelConsumption;

    @Column(nullable=false)
    private boolean availability;

    private int capacity;

    public Bus() {
    }

    public Bus(BusRequest busRequest) {
        this.busModel = busRequest.getBusModel();
        this.mark = busRequest.getMark();
        this.prodDate = busRequest.getProdDate();
        this.avFuelConsumption = busRequest.getAvFuelConsumption();
        this.availability = busRequest.isAvailability();
        this.capacity = busRequest.getCapacity();
    }
}
