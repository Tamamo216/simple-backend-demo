package com.example.demo.entity.postgres;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false)
  private Long id;

  @Column(
      nullable = false,
      unique = true
  )
  private String email;

  @Column(
      nullable = false,
      unique = true
  )
  private String password;

  @Column
  private String displayName;

}