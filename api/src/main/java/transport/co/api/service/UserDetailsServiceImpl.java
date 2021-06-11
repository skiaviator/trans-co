package transport.co.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import transport.co.api.model.AppUser;
import transport.co.api.repository.AppUserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final AppUserRepository appUserRepository;

    @Autowired
    public UserDetailsServiceImpl(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser=appUserRepository.findByUsername(username);
        if(appUser==null){
            throw new UsernameNotFoundException("No user found with username: " + username);
        }
       // boolean enabled = true;
       // boolean accountNonExpired = true;
        //boolean credentialsNonExpired = true;
       // boolean accountNonLocked = true;


        return appUser;

    }



}
