package com.rizwanmushtaq.SpringSecurityProject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity(debug = false)
@Configuration
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
    httpSecurity
        .authorizeHttpRequests((request) -> {
          request
              .requestMatchers("/api/route3", "/api/route4").hasRole("GUEST")
              .requestMatchers("/api/route1", "/api/route2").hasRole("ADMIN")
              .anyRequest().permitAll();
        })
        .formLogin(Customizer.withDefaults())
        .httpBasic(Customizer.withDefaults());
    return httpSecurity.build();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
