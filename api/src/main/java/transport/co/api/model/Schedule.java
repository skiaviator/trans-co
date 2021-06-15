package transport.co.api.model;

import lombok.Getter;
import lombok.Setter;
import transport.co.api.dto.StopDto;
import transport.co.api.request.ScheduleRequest;

import javax.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@Table(name="schedules")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "schedule_generator")
    @SequenceGenerator(name="schedule_generator", sequenceName = "schedule_seq")
    private long id;

  // @ManyToOne
 // @JoinColumn(name = "stop_id")
  // private Stop stop;
//
//    @ManyToOne
//    @JoinColumn(name = "bus_id")
//    private Bus bus;


    //private Time arrive;

    @Temporal(TemporalType.TIMESTAMP)
    private Date depart;

    public Schedule() {
    }

    private Schedule(ScheduleRequest scheduleRequest){
        this.depart=scheduleRequest.getDepart();
    }
    public static List<Schedule> fromList(List<ScheduleRequest> scheduleRequests){
        List<Schedule> schedules = scheduleRequests.stream()
                .map(scheduleRequest -> new Schedule(scheduleRequest))
                .collect(Collectors.toList());
        return schedules;
    }
}
