package app.core.controller;


import app.core.dto.Topic;
import app.core.service.TopicService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestController {


    @Autowired
    private TopicService topicService;

    @RequestMapping("/hello")
    public String hello() {
        return "Hello man";
    }


    @RequestMapping("/topics")
    public List<Topic> getTopcis() {
        return topicService.getListOfTopics();
    }

    @RequestMapping("/topics/{id}")
    public Topic getTopic(@PathVariable String id) {
        List<Topic> listOfTopics = topicService.getListOfTopics();
        Topic topic = topicService.getTopic(id);
        return topic;
    }


    @PostMapping("/topics")
    public void addTopic(@RequestBody Topic topic) {

        topicService.addTopic(topic);

    }

    @PutMapping("topics/{id}")
    public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
        topicService.updateTopic(id, topic);
        System.out.println(topic.toString() + " " + "successfully updated");
    }


    @DeleteMapping("topics/{id}")
    public void deleteTopic(@PathVariable String id) {
        topicService.deleteTopic(id);
        return;

    }
}
