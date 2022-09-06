package com.abstyle.mapper;

import com.abstyle.pojo.Topic;

import java.util.List;

public interface TopicMapper {

    int createTopic(Topic topic);

    List<Topic> latestTopic();

    int deleteTopic(String topicId);

    Topic selectTopicById(String topicId);
}
