package transport.co.api.request;

import lombok.Data;

@Data
public class CustomerRequest extends PersonRequest{
    private int points;
    private int notrealized;
}
