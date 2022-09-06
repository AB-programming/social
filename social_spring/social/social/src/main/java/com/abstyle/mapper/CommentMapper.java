package com.abstyle.mapper;

import com.abstyle.pojo.Comment;

import java.util.List;

public interface CommentMapper {
    int createComment(Comment comment);

    List<Comment> selectCommentByTarget(String commentTarget);

    List<Comment> selectComment();

    int deleteCommentById(String commentId);
}
