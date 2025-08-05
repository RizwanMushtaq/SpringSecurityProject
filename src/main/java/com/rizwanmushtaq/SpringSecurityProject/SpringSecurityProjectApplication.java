package com.rizwanmushtaq.SpringSecurityProject;

import com.rizwanmushtaq.SpringSecurityProject.entities.Role;
import com.rizwanmushtaq.SpringSecurityProject.entities.User;
import com.rizwanmushtaq.SpringSecurityProject.repositories.RoleRepository;
import com.rizwanmushtaq.SpringSecurityProject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class SpringSecurityProjectApplication implements CommandLineRunner {
  @Autowired
  private PasswordEncoder passwordEncoder;
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private RoleRepository roleRepository;

  public static void main(String[] args) {
    SpringApplication.run(SpringSecurityProjectApplication.class, args);
  }

  @Override
  public void run(String... args) {
    Role role1 = roleRepository.findByName("ROLE_ADMIN")
        .orElse(null);
    Role role2 = roleRepository.findByName("ROLE_GUEST")
        .orElse(null);
    if (role1 == null) {
      Role roleAdmin = Role
          .builder()
          .id(UUID.randomUUID().toString())
          .name("ROLE_ADMIN")
          .build();
      role1 = roleRepository.save(roleAdmin);
      System.out.println("Role created: " + roleAdmin.getName());
    }
    if (role2 == null) {
      Role roleGuest = Role
          .builder()
          .id(UUID.randomUUID().toString())
          .name("ROLE_GUEST")
          .build();
      role2 = roleRepository.save(roleGuest);
      System.out.println("Role created: " + roleGuest.getName());
    }
    User exitingUserRizwan =
        userRepository.findByUsername("rizwan").orElse(null);
    User exitingUserJohn =
        userRepository.findByUsername("john").orElse(null);
    if (exitingUserRizwan == null) {
      User userRizwan = User
          .builder()
          .id(UUID.randomUUID().toString())
          .username("rizwan")
          .password(passwordEncoder.encode("123"))
          .roles(List.of(role1, role2))
          .build();
      userRepository.save(userRizwan);
      System.out.println("User created with username: " + userRizwan.getUsername());
    }
    if (exitingUserJohn == null) {
      User userJohn = User
          .builder()
          .id(UUID.randomUUID().toString())
          .username("john")
          .password(passwordEncoder.encode("123"))
          .roles(List.of(role2))
          .build();
      userRepository.save(userJohn);
      System.out.println("User created with username: " + userJohn.getUsername());
    }
  }
}
