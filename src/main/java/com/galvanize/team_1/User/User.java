package com.galvanize.team_1.User;
import net.bytebuddy.asm.Advice;

import java.time.LocalDate;
import java.util.Date;


import javax.persistence.*;

@Entity
@Table(name= "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private String salt;
    private String bio;
    private LocalDate date;
    private String email;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User() {
        this.date = LocalDate.now();
    }

    public LocalDate getDate() {return date;}
    public void setDate(LocalDate date) {this.date = date;}

    public int getId() {
        return id;
    }

    public void setId(int id) {this.id = id;}

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    @Override
    public String toString() {
        return "User{" +
                "username =" + username  +
                "email =" + email  +
                "date joined =" + date  +
                "\n,bio = " + bio +
                '}';
    }


}
