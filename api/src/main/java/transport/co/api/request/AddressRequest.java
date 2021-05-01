package transport.co.api.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressRequest {
    private String country;
    private String city;
    private String postcode;
    private String street;
    private int buildingnumber;
    private int apartmentnumber;
}