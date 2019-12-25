package code.flatura.expendit;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    // Create 2 users for demo
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("user").password("{noop}password").roles("USER")
                .and()
                .withUser("admin").password("{noop}password").roles("USER", "ADMIN");

    }

    // Secure the endpoins with HTTP Basic authentication
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                //HTTP Basic authentication
                .httpBasic()
                .and()
                .authorizeRequests()
                //Authorization to Consumable API
                .antMatchers(HttpMethod.GET, "/api/consumables/**").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/api/consumables").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/api/consumables/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/consumables/**").hasRole("ADMIN")
                //Authorization to ConsumeFact API. Editing consumes is prohibited
                .antMatchers(HttpMethod.GET, "/api/consumes/**").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/api/consumes").hasRole("USER")
                .antMatchers(HttpMethod.DELETE, "/api/consumes/**").hasRole("ADMIN")
                //Authorization to Facility API
                .antMatchers(HttpMethod.GET, "/api/facilities/**").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/api/facilities").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/api/facilities/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/facilities/**").hasRole("ADMIN")
                //Authorization to Room API
                .antMatchers(HttpMethod.GET, "/api/rooms/**").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/api/rooms").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/api/rooms/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/rooms/**").hasRole("ADMIN")
                //Authorization to ConsumableType API
                .antMatchers(HttpMethod.GET, "/api/types/**").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/api/types").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/api/types/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/types/**").hasRole("ADMIN")
                //Authorization to CunsumableModel API
                .antMatchers(HttpMethod.GET, "/api/models/**").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/api/models").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/api/models/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/api/models/**").hasRole("ADMIN")
                .and()
                .csrf().disable()
                .formLogin().disable();
    }
}
