package com.galvanize.team_1.UserProfile;

import com.galvanize.team_1.User.User;
import com.galvanize.team_1.User.UserNotFoundException;
import com.galvanize.team_1.User.UserService;
import com.galvanize.team_1.comments.CommentList;
import com.galvanize.team_1.comments.CommentService;
import com.galvanize.team_1.posts.PostsList;
import com.galvanize.team_1.posts.PostsService;
import com.galvanize.team_1.saved_coins.SavedCoinsList;
import com.galvanize.team_1.saved_coins.SavedCoinsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserProfileController {

    UserService userService;
    PostsService postsService;
    CommentService commentService;
    SavedCoinsService savedCoinsService;

    public UserProfileController(UserService userService, PostsService postsService, CommentService commentService, SavedCoinsService savedCoinsService){
        this.userService = userService;
        this.postsService = postsService;
        this.commentService = commentService;
        this.savedCoinsService = savedCoinsService;
    }

    @GetMapping("/api/{username}")
    public ResponseEntity<UserProfile> getUserProfile(@PathVariable String username){
        try {
            User user = userService.getUserByUsername(username);
            UserProfile userProfile = new UserProfile(user);
            userProfile.setUserPosts(postsService.getUserPosts(user.getId()));
            userProfile.setUserComments(commentService.getUserComments(user.getId()));
            userProfile.setUserSavedCoins(savedCoinsService.getAllSavedCoinsByUser(user.getId()));
            return ResponseEntity.ok(userProfile);
        } catch (UserNotFoundException e){
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/api/{username}/posts")
    public ResponseEntity<PostsList> getUserPosts(@PathVariable String username){
        try {
            User user = userService.getUserByUsername(username);
            PostsList userPosts = postsService.getUserPosts(user.getId());
            return ResponseEntity.ok(userPosts);
        } catch (UserNotFoundException e){
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/api/{username}/comments")
    public ResponseEntity<CommentList> getUserComments(@PathVariable String username){
        try {
            User user = userService.getUserByUsername(username);
            CommentList userComments = commentService.getUserComments(user.getId());
            return ResponseEntity.ok(userComments);
        } catch (UserNotFoundException e){
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/api/{username}/coins")
    public ResponseEntity<SavedCoinsList> getUserSavedCoins(@PathVariable String username){
        try {
            User user = userService.getUserByUsername(username);
            SavedCoinsList userSavedCoins = savedCoinsService.getAllSavedCoinsByUser(user.getId());
            return ResponseEntity.ok(userSavedCoins);
        } catch (UserNotFoundException e){
            return ResponseEntity.noContent().build();
        }
    }
}
