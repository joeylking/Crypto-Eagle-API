package com.galvanize.team_1.UserProfile;

import com.galvanize.team_1.User.User;
import com.galvanize.team_1.comments.CommentList;
import com.galvanize.team_1.posts.PostsList;
import com.galvanize.team_1.saved_coins.SavedCoinsList;

import java.time.LocalDate;

public class UserProfile {
    private String username;
    private String bio;
    private String email;
    private LocalDate date;
    private PostsList userPosts;
    private CommentList userComments;
    private SavedCoinsList userSavedCoins;

    public UserProfile(){}

    public UserProfile(User user){
        this.username = user.getUsername();
        this.bio = user.getBio();
        this.email = user.getEmail();
        this.date = user.getDate();
    }
    public UserProfile(User user, PostsList userPosts, CommentList userComments, SavedCoinsList userSavedCoins){
        this.username = user.getUsername();
        this.bio = user.getBio();
        this.userPosts = userPosts;
        this.userComments = userComments;
        this.userSavedCoins = userSavedCoins;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getUsername() {
        return username;
    }

    public String getBio() {
        return bio;
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

    public SavedCoinsList getUserSavedCoins() {return userSavedCoins;}

    public void setUserSavedCoins(SavedCoinsList userSavedCoins) { this.userSavedCoins = userSavedCoins; }
}
