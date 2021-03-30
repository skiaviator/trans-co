package transport.co.api.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "addresses")
public class Address {

    @Id
    private long id;
    private String country;
    private String city;
    private String postcode;
    private String street;
    private int buildingnumber;
    private int apartmentnumber;

    @OneToMany(mappedBy = "address")
   // @JoinColumn(name = "addressId", updatable = false, insertable = false)
    private List<Employee> employees;
    @OneToMany(mappedBy = "address")
    // @JoinColumn(name = "addressId", updatable = false, insertable = false)
    private List<Driver> drivers;
    @OneToMany(mappedBy = "address")
  //  @JoinColumn(name = "addressId", updatable = false, insertable = false)
    private List<Customer> customers;
    @OneToOne(mappedBy = "address")
    // @JoinColumn(name = "addressId", updatable = false, insertable = false)
    private PermParking permParking;

}
