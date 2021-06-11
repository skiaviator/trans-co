package transport.co.api.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ReservationRequest {

    private long customerIdd;
    private long routeIdd;
    private long scheduleIdd;
}
