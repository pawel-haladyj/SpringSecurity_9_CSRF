package pl.haladyj.springsecurity9.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;
import pl.haladyj.springsecurity9.security.csrf.CustomCsrfTokenRepository;
import pl.haladyj.springsecurity9.security.filter.CsrfTokenLoggerFilter;

@Configuration
public class ProjectConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);

        http.csrf(c->{
            c.ignoringAntMatchers("/prefix/**"); //disabling certain endpoints
            c.csrfTokenRepository(new CustomCsrfTokenRepository()); //currently static solution, for testing purpose only
        });

        http.addFilterAfter(new CsrfTokenLoggerFilter(), CsrfFilter.class);
    }


}
