package com.ligoski.hive.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http.csrf().disable().authorizeHttpRequests((request) -> request.requestMatchers(HttpMethod.OPTIONS, "/**").permitAll().anyRequest().authenticated())
                .formLogin(withDefaults())
                .oauth2Login(withDefaults())
                .oauth2Client(withDefaults())
                .exceptionHandling(exception -> exception.accessDeniedPage("/login"))
                .build();
    }

}
