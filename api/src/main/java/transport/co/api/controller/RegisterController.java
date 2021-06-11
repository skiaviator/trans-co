package transport.co.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import transport.co.api.dto.CustomerDto;
import transport.co.api.model.Customer;
import transport.co.api.request.PersonRequest;
import transport.co.api.service.CustomerService;

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
