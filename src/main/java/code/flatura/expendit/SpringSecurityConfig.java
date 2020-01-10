package code.flatura.expendit;

import code.flatura.expendit.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity(debug = true)
@ComponentScan(basePackageClasses = CustomUserDetailsService.class)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService customUserDetailsService;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
    }

    // Secure the endpoins with HTTP Basic authentication
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //HTTP Basic authentication
                .httpBasic()
                .and()
                .authorizeRequests()
                //Authorization to User API
                .antMatchers(HttpMethod.GET, "/api/users/**").access("hasRole('ROLE_ADMIN')")
                .antMatchers(HttpMethod.POST, "/api/users").access("hasRole('ROLE_ADMIN')")
                .antMatchers(HttpMethod.PUT, "/api/users/**").access("hasRole('ROLE_ADMIN')")
                .antMatchers(HttpMethod.DELETE, "/api/users/**").access("hasRole('ROLE_ADMIN')")
                //Authorization to Consumable API
                .antMatchers(HttpMethod.GET, "/api/consumables/**").access("hasRole('ROLE_USER')")
                .antMatchers(HttpMethod.POST, "/api/consumables").access("hasRole('ROLE_ADMIN')")
                .antMatchers(HttpMethod.PUT, "/api/consumables/**").access("hasRole('ROLE_ADMIN')")
                .antMatchers(HttpMethod.DELETE, "/api/consumables/**").access("hasRole('ROLE_ADMIN')")
                //Authorization to ConsumeFact API. Editing consumes is prohibited
                .antMatchers(HttpMethod.GET, "/api/consumes/**").access("hasRole('ROLE_USER')")
                .antMatchers(HttpMethod.POST, "/api/consumes").access("hasRole('ROLE_USER')")
                .antMatchers(HttpMethod.DELETE, "/api/consumes/**").access("hasRole('ROLE_ADMIN')")
                //Authorization to Facility API
                .antMatchers(HttpMethod.GET, "/api/facilities/**").access("hasRole('ROLE_USER')")
                .antMatchers(HttpMethod.POST, "/api/facilities").access("hasRole('ROLE_ADMIN')")
                .antMatchers(HttpMethod.PUT, "/api/facilities/**").access("hasRole('ROLE_ADMIN')")
                .antMatchers(HttpMethod.DELETE, "/api/facilities/**").access("hasRole('ROLE_ADMIN')")
                //Authorization to Room API
                .antMatchers(HttpMethod.GET, "/api/rooms/**").access("hasRole('ROLE_USER')")
                .antMatchers(HttpMethod.POST, "/api/rooms").access("hasRole('ROLE_ADMIN')")
                .antMatchers(HttpMethod.PUT, "/api/rooms/**").access("hasRole('ROLE_ADMIN')")
                .antMatchers(HttpMethod.DELETE, "/api/rooms/**").access("hasRole('ROLE_ADMIN')")
                //Authorization to ConsumableType API
                .antMatchers(HttpMethod.GET, "/api/types/**").access("hasRole('ROLE_USER')")
                .antMatchers(HttpMethod.POST, "/api/types").access("hasRole('ROLE_ADMIN')")
                .antMatchers(HttpMethod.PUT, "/api/types/**").access("hasRole('ROLE_ADMIN')")
                .antMatchers(HttpMethod.DELETE, "/api/types/**").access("hasRole('ROLE_ADMIN')")
                //Authorization to ConsumableModel API
                .antMatchers(HttpMethod.GET, "/api/models/**").access("hasRole('ROLE_USER')")
                .antMatchers(HttpMethod.POST, "/api/models").access("hasRole('ROLE_ADMIN')")
                .antMatchers(HttpMethod.PUT, "/api/models/**").access("hasRole('ROLE_ADMIN')")
                .antMatchers(HttpMethod.DELETE,"/api/models/**").access("hasRole('ROLE_ADMIN')")
                .anyRequest().permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/403")
                .and()
                .csrf().disable()
                .formLogin().disable();
    }

    @Bean(name = "passwordEncoder")
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
