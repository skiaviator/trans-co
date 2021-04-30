package transport.co.api.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationRequest {

    private long customerId;
    private long routeId;
    private long scheduleId;
}
