package transport.co.api.controller;

import io.swagger.models.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import transport.co.api.dto.BusDto;
import transport.co.api.dto.RouteDto;
import transport.co.api.model.Bus;
import transport.co.api.request.BusRequest;
import transport.co.api.service.BusService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BusController {

    private final BusService busService;

    @GetMapping("/buses")
    public ResponseEntity<List<BusDto>> getBuses(){
        return new ResponseEntity<>(BusDto.fromList(busService.getBuses()), HttpStatus.OK);
    }

    @GetMapping("/buses/{id}")
    public ResponseEntity<BusDto> getSingleBus(@PathVariable Long id){
        return new ResponseEntity<>(BusDto.from(busService.getSingleBus(id)),HttpStatus.OK);
    }

    @PostMapping("/buses")
    public ResponseEntity<BusDto> addBus(@RequestBody BusRequest busRequest){
        Bus bus=busService.addBus(busRequest);
        return new ResponseEntity<>(BusDto.from(bus),HttpStatus.OK);
    }

    @PutMapping("/buses")
    public ResponseEntity<BusDto> editBus(@RequestBody BusDto busDto){
        return new ResponseEntity<>(busService.editBus(busDto),HttpStatus.OK);
    }

    @DeleteMapping("/buses")
    public ResponseEntity<Long> deleteBus(@RequestParam Long busId){
        boolean isRemoved = busService.deleteBus(busId);

        if (!isRemoved) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(busId, HttpStatus.OK);
    }

    @PatchMapping("/buses/{id}/assign-route")
    public ResponseEntity<?> assignRoute(@PathVariable Long id, @RequestParam Long routeId){
        boolean isAssigned=busService.assignRoute(id,routeId);

        if (!isAssigned){
            return new ResponseEntity<>("Route could not be assigned to bus!",HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>("Route has been succesfully assigned to bus!",HttpStatus.OK);
    }

    @PatchMapping("/buses/{id}/dismiss-route")
    public ResponseEntity<?> dismissRoute(@PathVariable Long id){
        boolean isDismissed=busService.dismissRoute(id);

        if (!isDismissed){
            return new ResponseEntity<>("Route could not be dismissed from this bus!",HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>("Route has been succesfully dismissed from this bus!",HttpStatus.OK);
    }
}
