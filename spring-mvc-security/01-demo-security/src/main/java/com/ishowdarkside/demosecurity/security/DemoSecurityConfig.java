package com.ishowdarkside.demosecurity.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        http.authorizeHttpRequests(configurer -> {

            configurer
                    .requestMatchers("/").hasRole("EMPLOYEE")
                    .requestMatchers("/leaders/**").hasRole("MANAGER")
                    .requestMatchers("/systems/**").hasRole("ADMIN")
                    .anyRequest().authenticated();


        }).formLogin(form -> {
            form.loginPage("/showLoginPage").loginProcessingUrl("/authenticateTheUser").permitAll();

        }).logout(e -> e.permitAll()).exceptionHandling(e -> e.accessDeniedPage("/access-denied"));



        return  http.build();
    }


    // add support for JDBC ... no more hardcoded users
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        //  this tells spring security to use JDBC authentication with our data source
        JdbcUserDetailsManager jdbcUserDetailsManager=  new JdbcUserDetailsManager(dataSource);
        // define query to retrieve a user by username
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select user_id from members where user_id=?"
        );

        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select user_id, role from roles where user_id=?"
        );

        // define query to retrieve the authorities  / roles by username
        return  jdbcUserDetailsManager;


    }




    /*
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){

        UserDetails john = User.builder().username("john").password("{noop}test123").roles("EMPLOYEE").build();
        UserDetails mary = User.builder().username("mary").password("{noop}test123").roles("EMPLOYEE","MANAGER").build();
        UserDetails susan = User.builder().username("susan").password("{noop}test123").roles("EMPLOYEE","MANAGER","ADMIN").build();

        return  new InMemoryUserDetailsManager(john,mary,susan);


    }


     */
}
