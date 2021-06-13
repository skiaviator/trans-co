package transport.co.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import transport.co.api.dto.RouteDto;
import transport.co.api.dto.ScheduleDto;
import transport.co.api.dto.StopDto;
import transport.co.api.model.Stop;
import transport.co.api.request.StopRequest;
import transport.co.api.service.StopService;

import java.util.List;

@RestController
public class StopController {

    private final StopService stopService;

    @Autowired
    public StopController(StopService stopService) {
        this.stopService = stopService;
    }

    @PostMapping("/stops")
    public ResponseEntity<Stop> addStop(@RequestBody StopRequest stopRequest){
        Stop stop=stopService.addStop(stopRequest);
        return new ResponseEntity<>((stop), HttpStatus.OK);
    }

    @GetMapping("/stops")
    public ResponseEntity<List<StopDto>> getStops(){
        return new ResponseEntity<>(stopService.getStops(),HttpStatus.OK);
    }

    @GetMapping("/stops/{id}")
    public ResponseEntity<StopDto> getSingleStop(@PathVariable Long stopId){
        return new ResponseEntity<>(StopDto.from(stopService.getSingleStop(stopId)),HttpStatus.OK);
    }

    @PutMapping("/stops")
    public ResponseEntity<StopDto> editRouteSchedule(@RequestBody StopDto stopDto){
        return new ResponseEntity<>(stopService.editStop(stopDto),HttpStatus.OK);}

    @DeleteMapping("/stops")
    public ResponseEntity<Long> deleteStop(@RequestParam Long stopId){
        boolean isRemoved = stopService.deleteStop(stopId);

        if (!isRemoved) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(stopId, HttpStatus.OK);
    }
}
