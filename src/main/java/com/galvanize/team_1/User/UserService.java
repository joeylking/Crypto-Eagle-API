package com.galvanize.team_1.User;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User updateUser(int id, String password, String bio, String email) {
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()){
            User dbUser = optionalUser.get();
            if(!bcrypt.matches(password + dbUser.getSalt(), dbUser.getPassword())){
                String salt = BCrypt.gensalt();
                String hashedPassword = bcrypt.encode(password + salt);
                dbUser.setSalt(salt);
                dbUser.setPassword(hashedPassword);
            }
            dbUser.setBio(bio);
            dbUser.setEmail(email);

            return userRepository.save(dbUser);
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
        Optional<User> userNameCheck = userRepository.findByUsername(user.getUsername());
        Optional<User> userIDCheck =userRepository.findById(user.getId());
        if(userNameCheck.isPresent()){
            throw new UserCreationException("Username already in use.");
        } else if (userIDCheck.isPresent()){
            throw new UserCreationException("A user with that ID already exists.");
        } else {
            String salt = BCrypt.gensalt();
            BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
            String hashedPassword = bcrypt.encode(user.getPassword() + salt);
            user.setSalt(salt);
            user.setPassword(hashedPassword);
            return userRepository.save(user);
        }
    }

    public UsersList getUsers(String userName) {
        List<User> users = userRepository.findAllByUsername(userName);
        if(!users.isEmpty()) {
            return UsersList.mapper(users);
        }
        return null;
    }

    public UsersList getAllUsers() {
        List<User> allUsers = userRepository.findAll();
        if(!allUsers.isEmpty()) {
            return UsersList.mapper(allUsers);
        }
        return null;
    }

    public UserDTO getUser(String username, String password) {
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if(optionalUser.isPresent()){
            User dbUser = optionalUser.get();
            if(bcrypt.matches(password + dbUser.getSalt(), dbUser.getPassword())){
                return UserDTO.mapper(dbUser);
            } else throw new UserAuthenticationException("Wrong password");
        }
        throw new UserNotFoundException("User not found");
    }

    public UserDTO getUserById(int userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isPresent()){
            return UserDTO.mapper(userRepository.save(optionalUser.get()));
        } else throw new UserNotFoundException("User not found");
    }

    public User getUserByUsername(String username) {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if(optionalUser.isPresent()){
            return optionalUser.get();
        } else throw new UserNotFoundException("User not found");
    }
}
