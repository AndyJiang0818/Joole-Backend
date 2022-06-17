package com.bezkoder.springjwt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bezkoder.springjwt.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> findUserById(int id);

  Optional<User> findByUsername(String username);

  User findUserByUsername(String userName);

  Boolean existsByUsername(String username);

  Boolean existsByEmail(String email);
}
