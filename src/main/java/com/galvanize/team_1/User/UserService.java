package com.galvanize.team_1.User;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User updateUser(int id, String userName, String password, String bio) {
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()){
            optionalUser.get().setUsername(userName);
            optionalUser.get().setPassword(password);
            optionalUser.get().setBio(bio);
            return userRepository.save(optionalUser.get());
        }
        return null;

    }

    public void deleteUser(int id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()){
            userRepository.delete(optionalUser.get());
        }else{
            throw new UserNotFoundException("Could not find user to delete");
        }
    }


    public User addUser(User user) {
        return userRepository.save(user);
    }

    public UsersList getUsers(String userName) {
        List<User> users = userRepository.findAllByUsername(userName);
        if(!users.isEmpty()) {
            return new UsersList(users);
        }
        return null;
    }

    public UsersList getAllUsers() {
        List<User> allUsers = userRepository.findAll();
        if(!allUsers.isEmpty()) {
            return new UsersList(allUsers);
        }
        return null;
    }

    public User getUser(String userName, String password) {
        return userRepository.findByUsernameAndPassword(userName, password).orElse(null);
    }

    public User getUserById(int userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isPresent()){
            return userRepository.save(optionalUser.get());
        } else throw new UserNotFoundException("User not found");
    }

    public User getUserByUsername(String username) {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if(optionalUser.isPresent()){
            return optionalUser.get();
        } else throw new UserNotFoundException("User not found");
    }
}
