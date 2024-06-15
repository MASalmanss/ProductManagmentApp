package com.MaSalman.productmanagement.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProductManagementSecurityConfig {

    @Bean
    InMemoryUserDetailsManager userDetailsManager(){
        UserDetails mehmet = User.builder().username("mehmet").password("1111").roles("user").build();
        UserDetails selin = User.builder().username("selin").password("2222").roles("user","superuser").build();
        UserDetails selim = User.builder().username("selim").password("3333").roles("user","superuser","admin").build();
        return new InMemoryUserDetailsManager(mehmet , selin , selim );
    };

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configure ->{
                   configure
                           .requestMatchers(HttpMethod.GET , "/api/category" ).hasRole("user")
                           .requestMatchers(HttpMethod.GET , "/api/category/**").hasRole("user")
                           .requestMatchers(HttpMethod.POST ,"/api/category" ).hasRole("superuser")
                           .requestMatchers(HttpMethod.PUT , "/api/category").hasRole("superuser")
                           .requestMatchers(HttpMethod.DELETE , "/api/category/**").hasRole("admin")

                            .requestMatchers(HttpMethod.GET , "/api/product" ).hasRole("user")
                            .requestMatchers(HttpMethod.GET , "/api/product/**").hasRole("user")
                            .requestMatchers(HttpMethod.POST ,"/api/product" ).hasRole("superuser")
                            .requestMatchers(HttpMethod.PUT , "/api/product").hasRole("superuser")
                            .requestMatchers(HttpMethod.DELETE , "/api/product/**").hasRole("admin");

        });

        http.httpBasic(Customizer.withDefaults());


        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
}
