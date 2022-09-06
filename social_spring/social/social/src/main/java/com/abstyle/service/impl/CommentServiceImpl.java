package com.abstyle.service.impl;

import com.abstyle.mapper.CommentMapper;
import com.abstyle.mapper.UserMapper;
import com.abstyle.pojo.Comment;
import com.abstyle.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentMapper commentMapper;
    @Autowired
    UserMapper userMapper;

    @Override
    public List<Comment> selectCommentByTarget(String commentTarget) {
        return commentMapper.selectCommentByTarget(commentTarget);
    }

    @Override
    public int createComment(Comment comment) {
        comment.setCommentId(System.currentTimeMillis() + "");
        comment.setCommentUserName(userMapper.selectUserByName(comment.getCommentName()).getUserName());
        return commentMapper.createComment(comment);
    }

    @Override
    public int deleteCommentById(String commentId) {
        return commentMapper.deleteCommentById(commentId);
    }

    @Override
    public List<Comment> selectComment() {
        return commentMapper.selectComment();
    }
}
