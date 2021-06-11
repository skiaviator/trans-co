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
                .antMatchers(HttpMethod.GET,"/routes").permitAll()
                .antMatchers(HttpMethod.POST,"/routes/**").hasRole("ADMIN")
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
