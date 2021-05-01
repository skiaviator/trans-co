package transport.co.api.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationRequest {

    private long customerIdd;
    private long routeIdd;
    private long scheduleIdd;
}
