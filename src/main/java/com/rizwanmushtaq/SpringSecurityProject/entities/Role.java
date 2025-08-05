package com.rizwanmushtaq.SpringSecurityProject.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "roles")
public class Role {
  @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
  List<User> users = new ArrayList<>();
  @Id
  private String id;
  private String name;
}
