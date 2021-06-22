package transport.co.api.request;

import lombok.Data;

@Data
public class AddressRequest {
    private String country;
    private String city;
    private String postcode;
    private String street;
    private int buildingnumber;
    private int apartmentnumber;
}
