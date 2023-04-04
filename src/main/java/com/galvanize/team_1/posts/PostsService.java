package com.galvanize.team_1.posts;

import com.galvanize.team_1.comments.CommentList;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostsService {

    PostsRepository postsRepository;

    public PostsService(PostsRepository postsRepository){
        this.postsRepository = postsRepository;
    }

    public PostsList getPosts() {
        return new PostsList(postsRepository.findAll());
    }

    public Post getPost(Integer id) {
        Optional<Post> optionalPost = postsRepository.findById(id);
        if (optionalPost.isPresent()) {
            return optionalPost.get();
        } else {
            throw new PostNotFoundException();
        }
    }

    public Post addPost(Post post){
        return postsRepository.save(post);
    }

    public Post updatePost(Integer id, String title, String body) {
        Optional<Post> optionalPost = postsRepository.findById(id);
        if (optionalPost.isPresent()) {
            optionalPost.get().setBody(body);
            optionalPost.get().setTitle(title);
            return postsRepository.save(optionalPost.get());
        }
        return null;
    }

    public void deletePost(Integer id) {
        Optional<Post> optionalPost = postsRepository.findById(id);
        if (optionalPost.isPresent()) {
            postsRepository.delete(optionalPost.get());
        } else {
            throw new PostNotFoundException();
        }
    }

    public PostsList getUserPosts(int userID) {
        PostsList userPosts = new PostsList(postsRepository.findAllByUserID(userID));
        return userPosts;
    }
}
