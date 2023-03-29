package com.galvanize.team_1.posts;

import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Post {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String body;

    @Column(name = "user_id")
    private int userID;

    public Post(){}

    public Post(String title, String body, int userID){
        this.title = title;
        this.body = body;
        this.userID = userID;
    }

    public int getId() {
        return id;
    }

    public int getUserID() {
        return userID;
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
