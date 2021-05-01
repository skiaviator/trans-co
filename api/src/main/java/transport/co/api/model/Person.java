package transport.co.api.model;

import lombok.Getter;
import lombok.Setter;
import transport.co.api.request.PersonRequest;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@MappedSuperclass
@Getter
@Setter
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_generator")
    @SequenceGenerator(name="person_generator", sequenceName = "person_seq")
    private long id;

    @Embedded
    private Address address;

    private String firstname;

    private String surname;

    private String email;

   @Temporal(TemporalType.DATE)
    private Date birthdate;

    private String phonenr;

  //  @OneToOne
  //  @JoinColumn(name = "personId", updatable = false, insertable = false)
 //   private Employee employee;
    public Person(){}
    public Person(PersonRequest personRequest){
        this.address= new Address(personRequest.getAddressRequest());
        this.firstname = personRequest.getFirstname();
        this.surname = personRequest.getSurname();
        this.email = personRequest.getEmail();
        this.birthdate = personRequest.getBirthdate();
        this.phonenr = personRequest.getPhonenr();
    }
}
