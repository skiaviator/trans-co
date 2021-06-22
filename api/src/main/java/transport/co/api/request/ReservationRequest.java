package transport.co.api.request;

import lombok.Data;

@Data
public class ReservationRequest {

    private long customerIdd;
    private long routeIdd;
    private long scheduleIdd;
}
