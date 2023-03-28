package com.galvanize.team_1.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional <User> findByUsernameAndPassword(String username, String password);
    Optional <User> findById(int id);
    List<User> findByUsername(String username);
}
