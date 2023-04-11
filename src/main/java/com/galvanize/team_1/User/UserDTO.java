package com.galvanize.team_1.User;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

public class UserDTO {
    private int id;

    private String username;
    private String bio;
    private LocalDate date;
    private String email;
    public UserDTO(int id, String username, String bio, LocalDate date, String email) {
        this.id = id;
        this.username = username;
        this.bio = bio;
        this.date = date;
        this.email = email;
    }

    public static UserDTO mapper(User user){
        return new UserDTO(
                user.getId(),
                user.getUsername(),
                user.getBio(),
                user.getDate(),
                user.getEmail()
        );
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getBio() {
        return bio;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getEmail() {
        return email;
    }
}
