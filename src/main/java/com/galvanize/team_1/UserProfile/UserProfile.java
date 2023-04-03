package com.galvanize.team_1.UserProfile;

import com.galvanize.team_1.User.User;
import com.galvanize.team_1.comments.CommentList;
import com.galvanize.team_1.posts.PostsList;

public class UserProfile {
    private String username;
    private String userBio;
    private PostsList userPosts;
    private CommentList userComments;

    public UserProfile(){}

    public UserProfile(User user){
        this.username = user.getUsername();
        this.userBio = user.getBio();
    }
    public UserProfile(User user, PostsList userPosts, CommentList userComments){
        this.username = user.getUsername();
        this.userBio = user.getBio();
        this.userPosts = userPosts;
        this.userComments = userComments;
    }

    public String getUsername() {
        return username;
    }

    public String getUserBio() {
        return userBio;
    }

    public PostsList getUserPosts() {
        return userPosts;
    }

    public void setUserPosts(PostsList userPosts) {
        this.userPosts = userPosts;
    }

    public CommentList getUserComments() {
        return userComments;
    }

    public void setUserComments(CommentList userComments) {
        this.userComments = userComments;
    }
}
