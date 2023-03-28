package com.galvanize.team_1.posts;

import java.util.ArrayList;
import java.util.List;

public class PostsList {
    private List<Post> posts;

    public PostsList(){
        this.posts = new ArrayList<>();
    }

    public PostsList(List<Post> posts){
        this.posts = posts;
    }

    public void setPosts(List<Post> posts){
        this.posts = posts;
    }

    public boolean isEmpty() {
        return this.posts.isEmpty();
    }
}
