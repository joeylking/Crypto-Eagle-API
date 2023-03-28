package com.galvanize.team_1;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController

public class PostsController {

    @GetMapping("/api/posts")

    public ResponseEntity<PostsList> getPosts(){
        PostsList postsList = PostsService.getPosts();
        return ResponseEntity.ok(postsList);

    }



}
