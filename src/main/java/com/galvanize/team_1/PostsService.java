package com.galvanize.team_1;

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
        return null;
    }

    public void deletePost(String id) {
    }
}
