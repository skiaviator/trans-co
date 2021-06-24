package transport.co.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import transport.co.api.config.ActiveUserStore;
import transport.co.api.model.AppUser;
import transport.co.api.service.UserDetailsServiceImpl;

import java.util.List;
import java.util.Locale;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserDetailsServiceImpl userDetailsService;

    @GetMapping("/logged-users")
    public ResponseEntity<List<String>> getLoggedUsers() {
        return new ResponseEntity<>(userDetailsService.getLoggedUsers(),HttpStatus.OK);
    }

    @GetMapping("/user")
    public ResponseEntity<AppUser> currentUser(Authentication authentication){
        return new ResponseEntity<>(userDetailsService.currentUser(authentication), HttpStatus.OK);
    }
    @GetMapping("/user-id")
    public ResponseEntity<Long> currentUserId(Authentication authentication){
        return new ResponseEntity<>(userDetailsService.currentUserId(authentication),HttpStatus.OK);}
}
