package com.rizwanmushtaq.SpringSecurityProject.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
  @Id
  private String id;
  private String username;
  private String password;
  private String role;
}
