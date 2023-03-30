package com.galvanize.team_1.comments;

import java.util.ArrayList;
import java.util.List;

public class CommentList {
    private List<Comment> commentList;

    public CommentList(){
        this.commentList = new ArrayList<>();
    }

    public CommentList(List<Comment> list) {
        this.commentList = list;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }
}
