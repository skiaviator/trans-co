package transport.co.api.dto;

import lombok.Data;
import transport.co.api.model.Schedule;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class ScheduleDto {
    private Long id;
    private Date depart;

    private ScheduleDto(Schedule schedule){
        this.id=schedule.getId();
        this.depart=schedule.getDepart();
    }

    public ScheduleDto() {
    }

    public static List<ScheduleDto> fromList(List<Schedule> schedules) {
        List<ScheduleDto> scheduleDtos = schedules.stream()
                .map(schedule -> new ScheduleDto(schedule))
                .collect(Collectors.toList());
        return scheduleDtos;
    }
    public static ScheduleDto from(Schedule schedule){
        ScheduleDto scheduleDto = new ScheduleDto();
        scheduleDto.setId(schedule.getId());
        scheduleDto.setDepart(schedule.getDepart());
        return scheduleDto;
    }
}
