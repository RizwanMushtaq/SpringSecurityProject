package com.rizwanmushtaq.SpringSecurityProject.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Role {
  @Id
  private int id;
  private String name;
}
