package app.core.service;


import app.core.dto.Topic;
import app.core.repo.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {


    @Autowired
    private TopicRepository topicRepository;


    public List<Topic> getListOfTopics() {

        List<Topic> topics = new ArrayList<>();

        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    public Topic getTopic(String id) {

        Optional<Topic> topic = topicRepository.findById(Long.valueOf(id));
        return topic.get();
    }

    public void addTopic(Topic topic) {
        topicRepository.save(topic);
    }

    public void updateTopic(Topic topic) {
        topicRepository.save(topic);
    }

    public void deleteTopic(String id) {
        topicRepository.deleteById(Long.valueOf(id));

    }
}
