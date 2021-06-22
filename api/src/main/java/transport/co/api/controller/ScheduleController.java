package transport.co.api.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import transport.co.api.dto.RouteDto;
import transport.co.api.dto.ScheduleDto;
import transport.co.api.model.Route;
import transport.co.api.model.Schedule;
import transport.co.api.request.ScheduleRequest;
import transport.co.api.service.ScheduleService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ScheduleController {

    private final ScheduleService scheduleService;

    @Autowired
    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping("/schedule")
    public ResponseEntity<List<ScheduleDto>> getRouteSchedule(@RequestParam long routeId){
        return new ResponseEntity<>(ScheduleDto.fromList(scheduleService.getRouteSchedule(routeId)),HttpStatus.OK);
    }

    @GetMapping("/schedule/{id}")
    public ResponseEntity<ScheduleDto> getSingleSchedule(@PathVariable Long id){
        return new ResponseEntity<>(ScheduleDto.from(scheduleService.getSingleSchedule(id)),HttpStatus.OK);
    }

    @PostMapping("/schedule")
    public ResponseEntity<List<ScheduleDto>> setRouteSchedule(@RequestBody List<ScheduleRequest> scheduleRequests,
                                                         @RequestParam Long routeId){
        List<Schedule> schedules=scheduleService.setRouteSchedule(scheduleRequests,routeId);
        return new ResponseEntity<>(ScheduleDto.fromList(schedules), HttpStatus.OK);
    }
    @PutMapping("/schedule")
    public ResponseEntity<List<ScheduleDto>> editRouteSchedule(@RequestBody ScheduleDto scheduleDto,
                              @RequestParam Long routeId){
        return new ResponseEntity<>(scheduleService.editRouteSchedule(scheduleDto,routeId),HttpStatus.OK);}

    @DeleteMapping("/schedule")
    public ResponseEntity<Long> deleteRouteSchedule(@RequestParam Long routeId){
        boolean isRemoved = scheduleService.deleteRouteSchedule(routeId);

        if (!isRemoved) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(routeId, HttpStatus.OK);
    }

}
