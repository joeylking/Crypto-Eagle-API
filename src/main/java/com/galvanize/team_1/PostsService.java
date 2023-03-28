package com.galvanize.team_1;

public class PostsService {

    PostsRepository postsRepository;

    public PostsService(PostsRepository postsRepository){
        this.postsRepository = postsRepository;
    }

    public PostsList getPosts() {
        return new PostsList(postsRepository.findAll());
    }

    public static Post getPost(String id) {
        return null;
    }

    public Post addPost(Post post) { return null; }

    public Post updatePost(String id, String title, String body) {
        return null;
    }

    public void deletePost(String id) {
    }
}
