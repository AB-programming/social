package com.abstyle.controller;

import com.abstyle.pojo.Comment;
import com.abstyle.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    @RequestMapping("/createComment")
    public int createComment(Comment comment){
        return commentService.createComment(comment);
    }

    @RequestMapping("/selectCommentByTarget")
    public List<Comment> selectCommentByTarget(String commentTarget){
        return commentService.selectCommentByTarget(commentTarget);
    }

    @RequestMapping("/selectComment")
    public List<Comment> selectComment(){
        return commentService.selectComment();
    }

    @RequestMapping("/deleteCommentById")
    public int deleteCommentById(String commentId){
        return commentService.deleteCommentById(commentId);
    }
}
