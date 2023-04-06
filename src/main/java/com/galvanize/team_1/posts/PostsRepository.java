package com.galvanize.team_1.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostsRepository extends JpaRepository<Post, Integer> {
    Optional<Post> findById(String id);

    List<Post> findAllByUserId(int userId);
}
