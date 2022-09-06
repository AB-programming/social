package com.abstyle.service.impl;

import com.abstyle.mapper.TopicMapper;
import com.abstyle.pojo.Topic;
import com.abstyle.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    TopicMapper topicMapper;

    @Override
    public int createTopic(Topic topic) {
        topic.setTopicId(System.currentTimeMillis() + "");
        return topicMapper.createTopic(topic);
    }

    @Override
    public List<Topic> latestTopic() {
        return topicMapper.latestTopic();
    }

    @Override
    public Topic selectTopicById(String topicId) {
        return topicMapper.selectTopicById(topicId);
    }

    @Override
    public int deleteTopic(String topicId) {
        return topicMapper.deleteTopic(topicId);
    }
}
