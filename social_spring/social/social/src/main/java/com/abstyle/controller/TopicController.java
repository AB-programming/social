package com.abstyle.controller;

import com.abstyle.pojo.Topic;
import com.abstyle.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/topic")
public class TopicController {
    @Autowired
    TopicService topicService;

    @RequestMapping("/createTopic")
    public int createTopic(Topic topic){
        return topicService.createTopic(topic);
    }

    @RequestMapping("/latestTopic")
    public List<Topic> latestTopic(){
        return topicService.latestTopic();
    }

    @RequestMapping("/deleteTopic")
    public int deleteTopic(String topicId){
        return topicService.deleteTopic(topicId);
    }

    @RequestMapping("/selectTopicById")
    public Topic selectTopicById(String topicId){
        return topicService.selectTopicById(topicId);
    }
}
