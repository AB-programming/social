package com.abstyle.pojo;

public class Topic {
    private String topicId;
    private String topicName;
    private String topicUserName;
    private String topicType;
    private String topicTime;
    private String topicContent;

    @Override
    public String toString() {
        return "Topic{" +
                "topicId=" + topicId +
                ", topicName='" + topicName + '\'' +
                ", topicUserName='" + topicUserName + '\'' +
                ", topicType='" + topicType + '\'' +
                ", topicTime='" + topicTime + '\'' +
                ", topicContent='" + topicContent + '\'' +
                '}';
    }

    public Topic(String topicId, String topicName, String topicUserName, String topicType, String topicTime, String topicContent) {
        this.topicId = topicId;
        this.topicName = topicName;
        this.topicUserName = topicUserName;
        this.topicType = topicType;
        this.topicTime = topicTime;
        this.topicContent = topicContent;
    }

    public Topic() {
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getTopicUserName() {
        return topicUserName;
    }

    public void setTopicUserName(String topicUserName) {
        this.topicUserName = topicUserName;
    }

    public String getTopicType() {
        return topicType;
    }

    public void setTopicType(String topicType) {
        this.topicType = topicType;
    }

    public String getTopicTime() {
        return topicTime;
    }

    public void setTopicTime(String topicTime) {
        this.topicTime = topicTime;
    }

    public String getTopicContent() {
        return topicContent;
    }

    public void setTopicContent(String topicContent) {
        this.topicContent = topicContent;
    }
}
