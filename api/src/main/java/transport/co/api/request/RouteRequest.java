package transport.co.api.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class RouteRequest {

    private float fee;
    private String routeName;

}
