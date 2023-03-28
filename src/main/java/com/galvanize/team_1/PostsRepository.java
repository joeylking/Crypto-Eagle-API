package com.galvanize.team_1;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostsRepository extends JpaRepository<Post, Integer> {

    Optional<Post> findById(String id);
}
