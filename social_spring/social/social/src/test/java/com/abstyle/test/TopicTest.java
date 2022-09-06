package com.abstyle.test;

import com.abstyle.pojo.Topic;
import com.abstyle.service.TopicService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext_mapper.xml","classpath:applicationContext_service.xml"})
public class TopicTest {
    @Autowired
    TopicService topicService;
    @Test
    public void testCreateTopic(){
        String topicId = System.currentTimeMillis() + "";
        Topic topic = new Topic(topicId, "11", "张三", "生活篇",
                "2002-12-08", "今天发一个帖子");
        int topic1 = topicService.createTopic(topic);
        System.out.println(topic1);
    }

    @Test
    public void testDeleteTopic(){
        int i = topicService.deleteTopic("1662215300333");
        System.out.println(i);
    }
    @Test
    public void testSelectTopicById(){
        Topic topic = topicService.selectTopicById("1662215385963");
        System.out.println(topic);
    }
}
