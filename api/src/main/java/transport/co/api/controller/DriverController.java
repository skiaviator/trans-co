package transport.co.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import transport.co.api.dto.CustomerDto;
import transport.co.api.dto.DriverDto;
import transport.co.api.model.Customer;
import transport.co.api.model.Driver;
import transport.co.api.request.PersonRequest;
import transport.co.api.service.CustomerService;
import transport.co.api.service.DriverService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DriverController {

    private final DriverService driverService;

    @GetMapping("/drivers")
    public ResponseEntity<List<DriverDto>> getDrivers(){
        return new ResponseEntity<>(DriverDto.fromList(driverService.getDrivers()), HttpStatus.OK);
    }

    @GetMapping("/drivers/{id}")
    public ResponseEntity<DriverDto> getSingleDriver(@PathVariable Long id){
        return new ResponseEntity<>(DriverDto.from(driverService.getSingleDriver(id)),HttpStatus.OK);}

    @PostMapping("/drivers")
    public ResponseEntity<DriverDto> addDriver(@RequestBody PersonRequest personRequest){
        Driver driver=driverService.addDriver(personRequest);
        return new ResponseEntity<>(DriverDto.from(driver),HttpStatus.OK);
    }


    @PutMapping("/drivers")
    public ResponseEntity<DriverDto> editDriver(@RequestBody DriverDto driverDto){
        return new ResponseEntity<>(driverService.editDriver(driverDto),HttpStatus.OK);}

    @DeleteMapping("/drivers")
    public ResponseEntity<Long> deleteDriver(@RequestParam Long driverId){
        boolean isRemoved = driverService.deleteDriver(driverId);

        if (!isRemoved) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(driverId, HttpStatus.OK);
    }

    @PatchMapping("/drivers/{id}/assign-bus")
    public ResponseEntity<?> assignBus(@PathVariable Long id, @RequestParam Long busId){
        boolean isAssigned=driverService.assignBus(id,busId);

        if (!isAssigned){
            return new ResponseEntity<>("Bus could not be assigned to driver!",HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>("Bus has been succesfully assigned to driver!",HttpStatus.OK);
    }

    @PatchMapping("/drivers/{id}/dismiss-bus")
    public ResponseEntity<?> dismissBus(@PathVariable Long id){
        boolean isDismissed=driverService.dismissBus(id);

        if (!isDismissed){
            return new ResponseEntity<>("Bus could not be dismissed from this driver!",HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>("Bus has been succesfully dismissed from this driver!",HttpStatus.OK);
    }

}


