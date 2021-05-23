package transport.co.api.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;
import transport.co.api.request.PersonRequest;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "employees")
public class Employee extends Person{


    private double pension;

    public Employee(PersonRequest personRequest){
        super(personRequest);
    }
}
