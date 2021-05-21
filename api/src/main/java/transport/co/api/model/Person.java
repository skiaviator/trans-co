package transport.co.api.model;

import lombok.Getter;
import lombok.Setter;
import transport.co.api.request.PersonRequest;

import javax.persistence.*;
import java.util.Date;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
@Entity
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

    @OneToOne(targetEntity = AppUser.class)
    @JoinColumn(name = "appUser")
    protected AppUser appUser;
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
