package transport.co.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import transport.co.api.config.ActiveUserStore;
import transport.co.api.model.AppUser;
import transport.co.api.repository.AppUserRepository;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final AppUserRepository appUserRepository;

    @Autowired
    public UserDetailsServiceImpl(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Autowired
    ActiveUserStore activeUserStore;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser=appUserRepository.findByUsername(username);
        if(appUser==null){
            throw new UsernameNotFoundException("No user found with username: " + username);
        }

        return appUser;
    }

    public List<String> getLoggedUsers() {
        return activeUserStore.getUsers();
    }

    public AppUser currentUser(Authentication authentication) {
        AppUser appUser=(AppUser) authentication.getPrincipal();
        return appUser;
    }
    public Long currentUserId(Authentication authentication) {
        AppUser appUser=(AppUser) authentication.getPrincipal();
        return appUser.getId();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
