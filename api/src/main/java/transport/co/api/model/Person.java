package transport.co.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@MappedSuperclass
@Getter
@Setter
public class Person {

    @Id
    @GeneratedValue
    private long id;

    @Embedded
    private Address address;

    private String firstname;

    private String surname;


    private String email;

   // private LocalDate birthdate;
   @Temporal(TemporalType.DATE)
    private Date birthdate;
    private String phonenr;

  //  @OneToOne
  //  @JoinColumn(name = "personId", updatable = false, insertable = false)
 //   private Employee employee;
}
