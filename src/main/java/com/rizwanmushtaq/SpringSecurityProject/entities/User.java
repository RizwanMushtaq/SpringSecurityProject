package com.rizwanmushtaq.SpringSecurityProject.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {
  @Id
  private String id;
  private String username;
  private String password;
  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private List<Role> roles = new ArrayList<>();
}
