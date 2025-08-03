package com.rizwanmushtaq.SpringSecurityProject;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity(debug = true)
@Configuration
public class SecurityConfig {
//  @Bean
//  public UserDetailsService userDetailsService() {
//    UserDetails user1 = User
//        .withDefaultPasswordEncoder()
//        .username("riz1")
//        .password("123")
//        .roles("ADMIN", "USER")
//        .build();
//    UserDetails user2 = User
//        .withDefaultPasswordEncoder()
//        .username("riz2")
//        .password("123")
//        .roles("USER")
//        .build();
//    InMemoryUserDetailsManager inMemoryUserDetailsManager =
//        new InMemoryUserDetailsManager(user1, user2);
//    return inMemoryUserDetailsManager;
//  }
}
