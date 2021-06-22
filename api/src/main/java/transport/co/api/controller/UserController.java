package transport.co.api.controller;

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

import java.util.List;
import java.util.Locale;

@RestController
public class UserController {
    @Autowired
    ActiveUserStore activeUserStore;

    @GetMapping("/loggedUsers")
    public ResponseEntity<List<String>> getLoggedUsers() {
        return new ResponseEntity<>(activeUserStore.getUsers(),HttpStatus.OK);
    }

    @GetMapping("/username")
    public ResponseEntity<AppUser> currentUser(Authentication authentication){
        AppUser appUser=(AppUser) authentication.getPrincipal();
        return new ResponseEntity<>(appUser, HttpStatus.OK);
    }
}
