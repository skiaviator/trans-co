package transport.co.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import transport.co.api.dto.CustomerDto;
import transport.co.api.model.Customer;
import transport.co.api.request.PersonRequest;
import transport.co.api.request.UserRequest;
import transport.co.api.service.CustomerService;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@RestController
@RequiredArgsConstructor
public class RegisterController {

    private final CustomerService customerService;

//    @GetMapping("/registration")
//    public String Registration(WebRequest request, Model model){
//        UserRequest userRequest= new UserRequest();
//        model.addAttribute("user",userRequest);
//        return "registration";
//    }


    @PostMapping("/registration")
    public ResponseEntity<CustomerDto> registerUserAccount(@RequestBody PersonRequest personRequest){
            Customer customer = customerService.registerNewCustomerAccount(personRequest);
            return new ResponseEntity<>(CustomerDto.from(customer),HttpStatus.OK);

    }

}
