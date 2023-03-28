package com.galvanize.team_1;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/api/posts/{id}")

    public ResponseEntity<Post> getPost(@PathVariable String id){
        try {
            Post post = postsService.getPost(id);
            return ResponseEntity.ok(post);
        } catch (Exception e){
            return ResponseEntity.noContent().build();
        }
    }

    @PatchMapping("/api/posts/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable String id,
                                           @RequestBody UpdatePostRequest update){
        try {
            Post post = postsService.updatePost(id, update.getTitle(), update.getBody());
            post.setTitle(update.getTitle());
            post.setBody(update.getBody());
            return ResponseEntity.ok(post);
        } catch (Exception e){
            return ResponseEntity.noContent().build();
        }
    }


}
