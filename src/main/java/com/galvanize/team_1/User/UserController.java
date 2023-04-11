package com.galvanize.team_1.User;

import com.galvanize.team_1.UserProfile.UserProfile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {

    UserService userService;

    public UserController(UserService userService) { this.userService = userService; }

    @PostMapping("/api/getuser")
    public ResponseEntity getUser(@RequestBody User loginUser) {
        try {
            UserDTO returnUser = userService.getUser(loginUser.getUsername(), loginUser.getPassword());
            return ResponseEntity.ok(returnUser);
        } catch (UserNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (UserAuthenticationException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/api/searchusers")
    public ResponseEntity<UsersList> getUsers(@RequestParam(required = true) String username) {
        UsersList searchList = userService.getUsers(username);
        return searchList.isEmpty() ? ResponseEntity.noContent().build() :
                ResponseEntity.ok(searchList);
    }

    @GetMapping("/api/users")
    public ResponseEntity<UsersList> getAllUsers() {
        UsersList allUsers = userService.getAllUsers();
        return allUsers.isEmpty() ? ResponseEntity.noContent().build() :
                ResponseEntity.ok(allUsers);
    }

    @PostMapping("/api/createuser")
    public ResponseEntity createUser(@RequestBody User user) {
        try {
            UserDTO returnUser = UserDTO.mapper(userService.addUser(user));
            return ResponseEntity.ok(returnUser);
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
        User returnUser = userService.updateUser(id, update.getPassword(), update.getBio(), update.getEmail());
        return returnUser.hideHashAndSalt();
    }

}
