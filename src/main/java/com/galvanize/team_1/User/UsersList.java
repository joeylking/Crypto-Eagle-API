package com.galvanize.team_1.User;

import java.util.ArrayList;
import java.util.List;


public class UsersList {

    private List<UserDTO> users;

    public UsersList() { this.users = new ArrayList<>(); }

    public UsersList(List<UserDTO> users) { this.users = users; }

    public List<UserDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserDTO> users) {
        this.users = users;
    }

    public static UsersList mapper(List<User> users){
        List<UserDTO> usersDTO = new ArrayList<>();
        users.forEach(user -> {
            UserDTO userDTO = UserDTO.mapper(user);
            usersDTO.add(userDTO);
        });
        return new UsersList(usersDTO);
    }

    @Override
    public String toString() {
        return "UsersList{" +
                "users=" + users +
                '}';
    }

    public boolean isEmpty() {
        return this.users.isEmpty();
    }

}
