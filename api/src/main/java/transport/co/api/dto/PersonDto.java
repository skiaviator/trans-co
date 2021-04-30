package transport.co.api.dto;


import java.util.Date;


public abstract class PersonDto {

    private long id;

    private AddressDto addressDto;

    private String firstname;

    private String surname;

    private String email;

    private Date birthdate;

    private String phonenr;
}
