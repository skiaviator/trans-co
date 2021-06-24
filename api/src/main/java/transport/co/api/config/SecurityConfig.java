package transport.co.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import transport.co.api.service.UserDetailsServiceImpl;

import java.util.HashMap;
import java.util.Map;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    private final UserDetailsServiceImpl userDetailsService;

    @Autowired
    public SecurityConfig(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.headers().frameOptions().disable();
        http
                .authorizeRequests()
                .antMatchers("/swagger-ui.html").permitAll()
                .antMatchers("/v2/api-docs").permitAll()
                .antMatchers("/webjars/**").permitAll()
                .antMatchers("/swagger-resources/**").permitAll()
                .antMatchers("/h2-console/**").permitAll()
                .antMatchers("/console/**").permitAll()
                .antMatchers("/registration").permitAll()

                .antMatchers(HttpMethod.GET,"/buses/**").hasAnyRole("ADMIN","CUSTOMER","DRIVER")
                .antMatchers(HttpMethod.POST,"/buses/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/buses/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/buses/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PATCH,"/buses/**").hasRole("ADMIN")

                .antMatchers(HttpMethod.GET,"/customers/**").hasAnyRole("ADMIN","DRIVER","CUSTOMER")
                .antMatchers(HttpMethod.POST,"/customers/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/customers/**").hasAnyRole("ADMIN","CUSTOMER")
                .antMatchers(HttpMethod.DELETE,"/customers/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PATCH,"/customers/**").hasAnyRole("ADMIN","DRIVER")

                .antMatchers(HttpMethod.GET,"/drivers/**").hasAnyRole("ADMIN","DRIVER")
                .antMatchers(HttpMethod.POST,"/drivers/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/drivers/**").hasAnyRole("ADMIN","DRIVER")
                .antMatchers(HttpMethod.DELETE,"/drivers/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PATCH,"/drivers/**").hasAnyRole("ADMIN")

                .antMatchers(HttpMethod.GET,"/reservations/**").hasAnyRole("ADMIN","DRIVER","CUSTOMER")
                .antMatchers(HttpMethod.POST,"/reservations/**").hasAnyRole("ADMIN","CUSTOMER")
                .antMatchers(HttpMethod.PUT,"/reservations/**").hasAnyRole("ADMIN","CUSTOMER","DRIVER")
                .antMatchers(HttpMethod.DELETE,"/reservations/**").hasAnyRole("ADMIN","CUSTOMER","DRIVER")

                .antMatchers(HttpMethod.GET,"/routes/**").hasAnyRole("ADMIN","CUSTOMER","DRIVER")
                .antMatchers(HttpMethod.POST,"/routes/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/routes/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/routes/**").hasRole("ADMIN")

                .antMatchers(HttpMethod.GET,"/schedule/**").hasAnyRole("ADMIN","CUSTOMER","DRIVER")
                .antMatchers(HttpMethod.POST,"/schedule/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/schedule/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/schedule/**").hasRole("ADMIN")

                .antMatchers(HttpMethod.GET,"/stops/**").hasAnyRole("ADMIN","CUSTOMER","DRIVER")
                .antMatchers(HttpMethod.POST,"/stops/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/stops/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/stops/**").hasRole("ADMIN")

                .antMatchers(HttpMethod.GET,"/logged-users").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/user-id").hasAnyRole("ADMIN","CUSTOMER","DRIVER")
                .antMatchers(HttpMethod.GET,"/user").hasAnyRole("ADMIN","CUSTOMER","DRIVER")

                .anyRequest().authenticated()
                .and()
                .formLogin()
                    .loginProcessingUrl("/login")
                    .usernameParameter("username")
                    .defaultSuccessUrl("/login")
                    .passwordParameter("password")
                    .successHandler(customAuthenticationSuccesHandler())
                    .permitAll()
                .and()
                .logout().permitAll()
                .and()
                .csrf().disable();
//                .exceptionHandling()
//                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED));

    }

    @Bean
    public AuthenticationSuccessHandler customAuthenticationSuccesHandler(){
        return new CustomAuthenticationSuccessHandler();
    }



}
