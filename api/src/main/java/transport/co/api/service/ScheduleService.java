package transport.co.api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import transport.co.api.dto.RouteDto;
import transport.co.api.dto.ScheduleDto;
import transport.co.api.dto.StopDto;
import transport.co.api.model.Schedule;
import transport.co.api.repository.ScheduleRepository;
import transport.co.api.request.ScheduleRequest;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final RouteService routeService;

    @Autowired
    public ScheduleService(ScheduleRepository scheduleRepository, RouteService routeService) {
        this.scheduleRepository = scheduleRepository;
        this.routeService = routeService;
    }

    public Schedule getSingleSchedule(long id) {
        return scheduleRepository.findById(id).orElseThrow();
    }

    public List<Schedule> setRouteSchedule(List<ScheduleRequest> scheduleRequests, Long routeId) {
        routeService.getSingleRoute(routeId).setSchedule(scheduleRepository.saveAll(Schedule.fromList(scheduleRequests)));
        return routeService.getSingleRoute(routeId).getSchedule();
    }

    public List<Schedule> getRouteSchedule(long routeId) {
        return routeService.getSingleRoute(routeId).getSchedule();
    }

    @Transactional
    public List<ScheduleDto> editRouteSchedule(ScheduleDto scheduleDto, Long routeId) {
        List<Schedule> schedules=routeService.getSingleRoute(routeId).getSchedule();
        schedules.forEach((schedule) -> {
            if(!schedule.getDepart().equals(scheduleDto.getDepart())) schedule.setDepart(scheduleDto.getDepart());
        });
       return ScheduleDto.fromList(schedules);
    }

    public boolean deleteRouteSchedule(Long routeId) {
      //  boolean isRemoved = routeService.getSingleRoute(routeId)
        if(!routeService.ifExist(routeId)) return false;
        List<Schedule> schedules =routeService.getSingleRoute(routeId).getSchedule();
        List<Long> ids = schedules.stream()
                .map(schedule -> schedule.getId())
                .collect(Collectors.toList());
        ids.forEach(Long -> {
            scheduleRepository.deleteById(Long);
        });
        return true;
    }
}
