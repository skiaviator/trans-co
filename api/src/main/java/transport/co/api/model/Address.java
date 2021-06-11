package transport.co.api.model;


import lombok.Getter;
import lombok.Setter;
import transport.co.api.request.AddressRequest;

import javax.persistence.*;

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

    public Address(){}

    public Address(AddressRequest addressRequest){
        this.country=addressRequest.getCountry();
        this.city=addressRequest.getCity();
        this.postcode=addressRequest.getPostcode();
        this.street=addressRequest.getStreet();
        this.buildingnumber=addressRequest.getBuildingnumber();
        this.apartmentnumber=addressRequest.getApartmentnumber();
    }


}
