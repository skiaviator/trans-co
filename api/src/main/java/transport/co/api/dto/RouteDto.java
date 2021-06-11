package transport.co.api.dto;

import lombok.Data;
import transport.co.api.model.Route;

import java.util.List;

@Data
public class RouteDto {

    private long id;

    private float fee;

    private String routeName;

    private String rideTime;

    private List<StopDto> stopDtoList;

    public RouteDto(){
    }

    public static RouteDto from(Route route){
        RouteDto routeDto=new RouteDto();
        routeDto.setId(route.getId());
        routeDto.setRouteName(route.getRouteName());
        routeDto.setFee(route.getFee());
        routeDto.setRideTime(route.getRideTime());
        routeDto.setStopDtoList(StopDto.fromList(route.getRouteStops()));
        return routeDto;
    }
}
