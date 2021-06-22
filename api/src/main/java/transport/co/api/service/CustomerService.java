package transport.co.api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import transport.co.api.dto.CustomerDto;
import transport.co.api.logic.ICustomerService;
import transport.co.api.model.*;
import transport.co.api.repository.AppUserRepository;
import transport.co.api.repository.CustomerRepository;
import transport.co.api.repository.ReservationRepository;
import transport.co.api.repository.RouteRepository;
import transport.co.api.request.PersonRequest;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerService implements ICustomerService {

    private final CustomerRepository customerRepository;
    private final AppUserRepository appUserRepository;
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public Customer getSingleCustomer(long id) {
        return customerRepository.findById(id).orElseThrow();
    }

    public Customer addCustomer(PersonRequest personRequest) {
        Customer customer=new Customer(personRequest);
        System.out.println(customer.getId());
        customerRepository.save(customer);
        return customer;
    }


    @Transactional
    public CustomerDto editCustomer(CustomerDto customerDto) {
        Customer customerEdited = customerRepository.findById(customerDto.getId()).orElseThrow();
        customerEdited.setAddress(Address.from(customerDto.getAddressDto()));
        customerEdited.setBirthdate(customerDto.getBirthdate());
        customerEdited.setEmail(customerDto.getEmail());
        customerEdited.setFirstname(customerDto.getFirstname());
        customerEdited.setSurname(customerDto.getSurname());
        customerEdited.setPhonenr(customerDto.getPhonenr());
        return CustomerDto.from(customerEdited);
    }

    public boolean deleteCustomer(long customerId) {
        if(!ifExist(customerId)) return false;
        customerRepository.deleteById(customerId);
        return true;
    }


    public Customer registerNewCustomerAccount(PersonRequest personRequest) {

        AppUser appUser = new AppUser(personRequest.getUserRequest().getUsername()
                ,passwordEncoder().encode(personRequest.getUserRequest().getPassword()),"ROLE_CUSTOMER");


        Customer customer=new Customer(personRequest);
        if (emailExists(personRequest.getEmail())){
            throw new HttpServerErrorException(HttpStatus.IM_USED);
        }
        appUser.setPerson(customer);
        appUserRepository.save(appUser);

        customer.setAppUser(appUser);
        customerRepository.save(customer);

        return customer;

    }

    public boolean ifExist(Long customerId){
        return customerRepository.existsById(customerId);
    }

    private boolean emailExists(String email){
        return customerRepository.findByEmail(email) != null;
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @EventListener(ApplicationReadyEvent.class)
    public void get() {
        AppUser appUser=new AppUser("Jan",passwordEncoder().encode("Nowak"),"ROLE_CUSTOMER");
        appUserRepository.save(appUser);

        AppUser appUse2=new AppUser("Admin",passwordEncoder().encode("Adminowski"),"ROLE_ADMIN");
        appUserRepository.save(appUse2);

        AppUser appUse3=new AppUser("Driver",passwordEncoder().encode("Bus"),"ROLE_EMPLOYEE");
        appUserRepository.save(appUse3);

        AppUser appUse4=new AppUser("Office",passwordEncoder().encode("Worker"),"ROLE_DRIVER");
        appUserRepository.save(appUse4);

    }

    @Transactional
    public boolean grantPoints(Long id, Integer points) {
        if(!ifExist(id)) return false;
        if(points<=0||points==null) return false;
        Customer customer= customerRepository.findById(id).orElseThrow();
        Integer currentPoints=customer.getPoints();
        customer.setPoints(currentPoints+points);
        return true;
    }

    @Transactional
    public boolean grantNotRealized(Long id) {
        if(!ifExist(id)) return false;
        Customer customer= customerRepository.findById(id).orElseThrow();
        customer.setNotrealized(customer.getNotrealized()+1);
        return true;
    }

}
