package transport.co.api.dto;

import lombok.Getter;
import lombok.Setter;
import transport.co.api.model.Address;

@Getter
@Setter
public class AddressDto {
    private String country;
    private String city;
    private String postcode;
    private String street;
    private int buildingnumber;
    private int apartmentnumber;

    public static AddressDto from(Address address){
        AddressDto addressDto=new AddressDto();
        addressDto.setApartmentnumber(address.getApartmentnumber());
        addressDto.setBuildingnumber(address.getBuildingnumber());
        addressDto.setCity(address.getCity());
        addressDto.setCountry(address.getCountry());
        addressDto.setStreet(address.getStreet());
        addressDto.setPostcode(address.getPostcode());
        return addressDto;
    }
}
