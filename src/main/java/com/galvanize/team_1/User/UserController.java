package com.galvanize.team_1.User;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    UserService userService;

    @PostMapping("/api/createuser")
    public User createUser(@RequestBody User user) { return userService.addUser(); }

    @DeleteMapping("/api/deleteuser/{id}")
    public ResponseEntity deleteUser(@PathVariable int id) {
        try {
            userService.deleteUser(id);
        }catch (UserNotFoundException e) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.accepted().build();
    }

    @PutMapping("/api/updatepassword/{id}")
    public User updatePassword(@PathVariable int id,
                               @RequestBody UpdatePasswordRequest update) {

    }
}
