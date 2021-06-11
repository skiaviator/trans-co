package transport.co.api.request;

import lombok.Data;

import java.util.List;

@Data
public class RouteRequest {

    private float fee;
    private String routeName;
    private String rideTime;
    private List<StopRequest> stopRequests;

}
