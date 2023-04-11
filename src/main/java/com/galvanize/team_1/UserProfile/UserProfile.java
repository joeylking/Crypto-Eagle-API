package com.galvanize.team_1.UserProfile;

import com.galvanize.team_1.User.User;
import com.galvanize.team_1.User.UserDTO;
import com.galvanize.team_1.comments.CommentList;
import com.galvanize.team_1.posts.PostsList;
import com.galvanize.team_1.saved_coins.SavedCoinsList;

import java.time.LocalDate;

public class UserProfile {
    private UserDTO user;
    private PostsList userPosts;
    private CommentList userComments;
    private SavedCoinsList userSavedCoins;

    public UserProfile(){}

    public UserProfile(UserDTO user){
        this.user = user;
    }
    public UserProfile(UserDTO user, PostsList userPosts, CommentList userComments, SavedCoinsList userSavedCoins){
        this.user = user;
        this.userPosts = userPosts;
        this.userComments = userComments;
        this.userSavedCoins = userSavedCoins;
    }

    public UserDTO getUser() { return user; }

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
