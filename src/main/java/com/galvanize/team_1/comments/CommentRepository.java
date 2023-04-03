package com.galvanize.team_1.comments;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
//    @Query(value = "SELECT * FROM comments WHERE post_id = 1;", nativeQuery = true)
    List<Comment> findAllByPostId(int id);

    List<Comment> findAllByUserId(int userId);
}
