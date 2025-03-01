package com.example.demo.repository.postgres;

import com.example.demo.entity.postgres.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByEmail(String email);

  long removeByEmail(String email);

  @Transactional
  @Modifying
  @Query("update User u set u.displayName = ?1 where u.email = ?2")
  void updateDisplayNameByEmail(String displayName, String email);
}