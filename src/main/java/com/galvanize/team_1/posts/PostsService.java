package com.galvanize.team_1.posts;

import java.util.Optional;

public class PostsService {

    PostsRepository postsRepository;

    public PostsService(PostsRepository postsRepository){
        this.postsRepository = postsRepository;
    }

    public PostsList getPosts() {
        return new PostsList(postsRepository.findAll());
    }

    public Post getPost(String id) {
        return postsRepository.findById(id).orElse(null);
    }

    public Post addPost(Post post){
        return postsRepository.save(post);
    }

    public Post updatePost(String id, String title, String body) {
        Optional<Post> optionalPost = postsRepository.findById(id);
        if (optionalPost.isPresent()) {
            optionalPost.get().setBody(body);
            optionalPost.get().setTitle(title);
            return postsRepository.save(optionalPost.get());
        }
        return null;
    }

    public void deletePost(String id) {
        Optional<Post> optionalPost = postsRepository.findById(id);
        if (optionalPost.isPresent()) {
            postsRepository.delete(optionalPost.get());
        } else {
            throw new PostNotFoundException();
        }
    }
}
