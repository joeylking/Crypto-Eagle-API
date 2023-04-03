package com.galvanize.team_1.comments;

import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CommentService {
    CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public CommentList getAllComments(){
        return new CommentList(commentRepository.findAll());
    }
    public CommentList getAllCommentsByPostId(String id){
        return new CommentList(commentRepository.findAllByPostId(Integer.parseInt(id)));
    }

    public Comment addCommentToPost(Comment comment) {
        return commentRepository.save(comment);
    }

    public Comment editComment(Comment comment, String id) {
        Optional<Comment> optionalComment = commentRepository.findById(Integer.parseInt(id));
        if (optionalComment.isEmpty()) {
            return null;
        } else {
            optionalComment.get().setBody(comment.getBody());
        }
        return commentRepository.save(optionalComment.get());
    }

    public void deleteComment(String id) {
        Optional<Comment> optionalComment = commentRepository.findById(Integer.parseInt(id));
        if (optionalComment.isEmpty()){
            throw new NoSuchElementException("Comment not found.");
        } else {
            commentRepository.delete(optionalComment.get());
        }

    }

    public CommentList getUserComments(int userId) {
        CommentList userComments = new CommentList(commentRepository.findAllByUserId(userId));
        return userComments;
    }
}
