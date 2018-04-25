package at.refugeescode.accountancy.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/invoices").fullyAuthenticated()
                .antMatchers("/").permitAll()
                .anyRequest().denyAll()
                .and()
                .csrf().disable()
                .httpBasic();

        /*
        http.authorizeRequests()
                .antMatchers("/invoices").authenticated()
                .anyRequest().permitAll()
                .and()
                .csrf().disable();
         */
    }

}