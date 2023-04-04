package com.galvanize.team_1.User;

import com.galvanize.team_1.UserProfile.UserProfile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    UserService userService;

    public UserController(UserService userService) { this.userService = userService; }

    @GetMapping("/api/getuser")
    public ResponseEntity<User> getUser(@RequestBody User loginUser) {
        try {
            User user = userService.getUser(loginUser.getUsername(), loginUser.getPassword());
            if(user == null) throw new UserNotFoundException("User with given parameters does not exist");

            return ResponseEntity.ok(user);
        } catch (UserNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/api/searchusers")
    public ResponseEntity<UsersList> getUsers(@RequestParam(required = true) String username) {
        UsersList searchList;
        searchList = userService.getUsers(username);

        return searchList.isEmpty() ? ResponseEntity.noContent().build() :
                ResponseEntity.ok(searchList);
    }

    @GetMapping("/api/users")
    public ResponseEntity<UsersList> getAllUsers() {
        UsersList allUsers;
        allUsers = userService.getAllUsers();

        return allUsers.isEmpty() ? ResponseEntity.noContent().build() :
                ResponseEntity.ok(allUsers);
    }

    @PostMapping("/api/createuser")
    public ResponseEntity createUser(@RequestBody User user) {
        try {
            return ResponseEntity.ok(userService.addUser(user));
        } catch (UserCreationException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/api/deleteuser/{id}")
    public ResponseEntity deleteUser(@PathVariable int id) {
        try {
            userService.deleteUser(id);
        }catch (UserNotFoundException e) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.accepted().build();
    }

    @PutMapping("/api/updateuser/{id}")
    public User updateUser(@PathVariable int id,
                               @RequestBody User update) {
        User user = userService.updateUser(id, update.getPassword(), update.getBio(), update.getEmail());
        user.setPassword(update.getPassword());
        user.setBio(update.getBio());
        user.setEmail(update.getEmail());
        return user;
    }

}
