package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {


    // add support for JDBC ... no more hardcodded users
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager jdbcUserDetailsManager =  new JdbcUserDetailsManager(dataSource);

        // define query to retrieve a user by username
        jdbcUserDetailsManager.setUsersByUsernameQuery("select user_id, pw, active from members where user_id=?");
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select user_id, role from roles where user_id=?");


        // define query to retrieve the authorities / roles by username

        return jdbcUserDetailsManager;


    };

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws  Exception {

        http.authorizeHttpRequests(configure -> {
            configure.requestMatchers(HttpMethod.GET,"/api/employees").hasRole("EMPLOYEE");
            configure.requestMatchers(HttpMethod.GET,"/api/employees/**").hasRole("EMPLOYEE");
            configure.requestMatchers(HttpMethod.POST,"/api/employees").hasRole("EMPLOYEE MANAGER");
            configure.requestMatchers(HttpMethod.PUT,"/api/employees").hasRole("EMPLOYEE MANAGER");
            configure.requestMatchers(HttpMethod.DELETE,"/api/employees/**").hasRole("EMPLOYEE MANAGER ADMIN");
        });

        // use HTTP Basic Auth
        http.httpBasic(Customizer.withDefaults());

        // Disable Cross Site request Forgery (CSRF)
        // In general, not required for stateless REST APIs taht use POST, PUT, DELETE and / or patch;
        http.csrf(csrf -> csrf.disable());

        return  http.build();
    }








    /*
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails john  = User.builder().username("john").password("{noop}test123").roles("EMPLOYEE").build();
        UserDetails mary  = User.builder().username("mary").password("{noop}test123").roles("EMPLOYEE","MANAGER").build();
        UserDetails susan  = User.builder().username("susan").password("{noop}test123").roles("EMPLOYEE","MANAGER","ADMIN").build();

        return  new InMemoryUserDetailsManager(john,mary,susan);

    }

*/
}
