package com.galvanize.team_1;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController

public class PostsController {

    PostsService postsService;

    @GetMapping("/api/posts")
    public ResponseEntity<PostsList> getPosts(){
        PostsList postsList = postsService.getPosts();
        return ResponseEntity.ok(postsList);

    }

    @PostMapping("/api/posts")
    public Post addPost(@RequestBody Post post){
        return postsService.addPost(post);
    }



}
