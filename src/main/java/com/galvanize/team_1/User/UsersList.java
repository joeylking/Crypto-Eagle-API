package com.galvanize.team_1.User;

import java.util.ArrayList;
import java.util.List;


public class UsersList {

    private List<User> users;

    public UsersList() { this.users = new ArrayList<>(); }

    public UsersList(List<User> users) { this.users = users; }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
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
