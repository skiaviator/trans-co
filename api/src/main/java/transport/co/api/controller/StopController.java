package transport.co.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
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
    public List<StopDto> getStops(){
        return stopService.getStops();
    }

}
