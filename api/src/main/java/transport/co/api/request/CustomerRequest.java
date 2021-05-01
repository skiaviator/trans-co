package transport.co.api.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerRequest extends PersonRequest{
    private int points;
    private int notrealized;
}
