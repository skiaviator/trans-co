package transport.co.api.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Embeddable
@Getter
@Setter
public class Address {

    private String country;
    private String city;
    private String postcode;
    private String street;
    private int buildingnumber;
    private int apartmentnumber;




}
