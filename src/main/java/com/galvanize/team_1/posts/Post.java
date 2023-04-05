package com.galvanize.team_1.posts;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "posts")
public class Post {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String body;
    private LocalDate date;
    private int userID;
    private String username;

    public Post(){}

    public Post(String title, String body, int userID){
        this.title = title;
        this.body = body;
        this.userID = userID;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int id){
        this.userID = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Post{" +
                "title=" + title +
                ", body='" + body + '\'' +
                ", userID='" + userID + '\'' +
                '}';
    }

}
