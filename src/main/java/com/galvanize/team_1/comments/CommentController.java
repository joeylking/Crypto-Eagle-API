package com.galvanize.team_1.comments;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/comments")
public class CommentController {
    private CommentService commentService;
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping(value = {"", "/"})
    public ResponseEntity<CommentList> getAllComments(){
        CommentList commentList = commentService.getAllComments();
        HttpStatus status = commentList.getCommentList().isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK;
        return new ResponseEntity<>(commentList, status);
    }

    @GetMapping("/post/{id}")
    public ResponseEntity<CommentList> getAllCommentsByPostId(@PathVariable String id){
        CommentList commentList = commentService.getAllCommentsByPostId(id);

        HttpStatus status = commentList.getCommentList().isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK;

        return new ResponseEntity<>(commentList, status);
    }

    @PostMapping("/add")
    public ResponseEntity<Comment> addCommentToPost(@RequestBody Comment comment){
        return new ResponseEntity<>(commentService.addCommentToPost(comment), HttpStatus.OK);
    }

    @PatchMapping("/edit/{id}")
    public ResponseEntity<Comment> editComment(@RequestBody Comment comment, @PathVariable String id){
        Comment updatedComment = commentService.editComment(comment, id);

        HttpStatus status = updatedComment == null ? HttpStatus.NOT_FOUND : HttpStatus.OK;

        return new ResponseEntity<>(updatedComment, status);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable String id) {
        try {
            commentService.deleteComment(id);
        } catch(Exception e){
            return new ResponseEntity<>("Delete unsuccessful.", HttpStatus.NOT_FOUND);

        }
            return new ResponseEntity<>("Delete successful.", HttpStatus.ACCEPTED);
    }

}
