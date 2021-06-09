package transport.co.api.service;

import jdk.jshell.spi.ExecutionControl;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import transport.co.api.logic.ICustomerService;
import transport.co.api.model.AppUser;
import transport.co.api.model.Customer;
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

    private final ReservationRepository reservationRepository;
    private final CustomerRepository customerRepository;
    private final RouteRepository routeRepository;
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
    public Customer editCustomer(Customer customer) {
        Customer customerEdited = customerRepository.findById(customer.getId()).orElseThrow();
        customerEdited.setAddress(customer.getAddress());
        customerEdited.setBirthdate(customer.getBirthdate());
        customerEdited.setEmail(customer.getEmail());
        customerEdited.setFirstname(customer.getFirstname());
        customerEdited.setSurname(customer.getSurname());
        customerEdited.setPhonenr(customer.getPhonenr());
        return customerEdited;
    }

    public void deleteCustomer(long id) {
        customerRepository.deleteById(id);
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

        AppUser appUse3=new AppUser("Driver",passwordEncoder().encode("Bus"),"OFFICE_WORKER");
        appUserRepository.save(appUse2);

        AppUser appUse4=new AppUser("Office",passwordEncoder().encode("Worker"),"DRIVER");
        appUserRepository.save(appUse2);

    }
}
