package com.galvanize.team_1.User;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    UserService userService;

    @GetMapping("/api/login")
    public ResponseEntity<User> loginUser(@RequestBody User login) {
        try{
            User user = userService.login();
            return ResponseEntity.ok(user);
        }catch (UserNotFoundException e) {
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping("/api/searchusers")
    public ResponseEntity<UsersList> getUsers(@RequestParam(required = true) String userName) {
        UsersList searchList;
        searchList = userService.getUsers(userName);

        return searchList.isEmpty() ? ResponseEntity.noContent().build() :
                ResponseEntity.ok(searchList);

    }

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

    @PutMapping("/api/updateuser/{id}")
    public User updateUser(@PathVariable int id,
                               @RequestBody User update) {
        User user = userService.updateUser(id, update.getUserName(), update.getPassword(), update.getBio());
        user.setPassword(update.getPassword());
        user.setBio(update.getBio());
        return user;
    }
}
