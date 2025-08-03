package com.rizwanmushtaq.SpringSecurityProject;

import com.rizwanmushtaq.SpringSecurityProject.entities.User;
import com.rizwanmushtaq.SpringSecurityProject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.UUID;

@SpringBootApplication
public class SpringSecurityProjectApplication implements CommandLineRunner {
  @Autowired
  private PasswordEncoder passwordEncoder;
  @Autowired
  private UserRepository userRepository;

  public static void main(String[] args) {
    SpringApplication.run(SpringSecurityProjectApplication.class, args);
  }

  @Override
  public void run(String... args) {
    User exitingUser = userRepository.findByUsername("rizwan").orElse(null);
    if (exitingUser != null) {
      System.out.println("User already exists with username: " + exitingUser.getUsername());
      return;
    }
    User user = new User();
    user.setId(UUID.randomUUID().toString());
    user.setUsername("rizwan");
    user.setPassword(passwordEncoder.encode("123"));
    user.setRole("USER");
    userRepository.save(user);
    System.out.println("User created with username: " + user.getUsername());
  }
}
