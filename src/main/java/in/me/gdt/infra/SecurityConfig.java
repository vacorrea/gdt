package in.me.gdt.infra;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired DataSource dataSourceSecurity;
    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication().dataSource(dataSourceSecurity).usersByUsernameQuery("select user_name, password, true from appuser where user_name=?")
                .authoritiesByUsernameQuery(
                        "select au.user_name, r.name from user_role ur join appuser au on (au.user_id=ur.user_id) join role r on (r.role_id=ur.role_id) where au.user_name=?")
                .passwordEncoder(new BCryptPasswordEncoder());
    }
    /*
    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user =
             User.withDefaultPasswordEncoder()
                .username("admin")
                .password("admin")
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user);
    }
}

*/
}