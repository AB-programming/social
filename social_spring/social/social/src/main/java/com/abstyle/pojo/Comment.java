package com.abstyle.pojo;

public class Comment {
    private String commentId;
    private String commentTarget;
    private String commentName;
    private String commentUserName;

    @Override
    public String toString() {
        return "Comment{" +
                "commentId='" + commentId + '\'' +
                ", commentTarget='" + commentTarget + '\'' +
                ", commentName='" + commentName + '\'' +
                ", commentUserName='" + commentUserName + '\'' +
                ", commentContent='" + commentContent + '\'' +
                ", commentTime='" + commentTime + '\'' +
                '}';
    }

    public Comment(String commentTarget, String commentName, String commentUserName, String commentContent, String commentTime) {
        this.commentTarget = commentTarget;
        this.commentName = commentName;
        this.commentUserName = commentUserName;
        this.commentContent = commentContent;
        this.commentTime = commentTime;
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String getCommentTarget() {
        return commentTarget;
    }

    public void setCommentTarget(String commentTarget) {
        this.commentTarget = commentTarget;
    }

    public String getCommentName() {
        return commentName;
    }

    public void setCommentName(String commentName) {
        this.commentName = commentName;
    }

    public String getCommentUserName() {
        return commentUserName;
    }

    public void setCommentUserName(String commentUserName) {
        this.commentUserName = commentUserName;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public String getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(String commentTime) {
        this.commentTime = commentTime;
    }

    public Comment(String commentId, String commentTarget, String commentName, String commentUserName, String commentContent, String commentTime) {
        this.commentId = commentId;
        this.commentTarget = commentTarget;
        this.commentName = commentName;
        this.commentUserName = commentUserName;
        this.commentContent = commentContent;
        this.commentTime = commentTime;
    }

    public Comment() {
    }

    private String commentContent;
    private String commentTime;
}
