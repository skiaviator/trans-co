package transport.co.api.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class CustomerRequest extends PersonRequest{
    private int points;
    private int notrealized;
}
