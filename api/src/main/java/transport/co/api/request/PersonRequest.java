package transport.co.api.request;

import lombok.Data;

import java.util.Date;

@Data
public class PersonRequest {

    private AddressRequest addressRequest;

    private UserRequest userRequest;

    private String firstname;

    private String surname;

    private String email;

    private Date birthdate;

    private String phonenr;

    public PersonRequest() { }

    public PersonRequest(AddressRequest addressRequest,UserRequest userRequest, String firstname, String surname, String email, Date birthdate, String phonenr) {
        this.addressRequest = addressRequest;
        this.firstname = firstname;
        this.surname = surname;
        this.email = email;
        this.birthdate = birthdate;
        this.phonenr = phonenr;
        this.userRequest=userRequest;
    }
}
