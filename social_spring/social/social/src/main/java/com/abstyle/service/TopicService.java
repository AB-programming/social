package com.abstyle.service;

import com.abstyle.pojo.Topic;

import java.util.List;

public interface TopicService {
    int createTopic(Topic topic);

    List<Topic> latestTopic();

    int deleteTopic(String topicId);

    Topic selectTopicById(String topicId);
}
