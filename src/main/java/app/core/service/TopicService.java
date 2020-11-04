package app.core.service;


import app.core.dto.Topic;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {


    private List<Topic> topics = new ArrayList<>(
            Arrays.asList(
                    new Topic("1", "TopOne", "somth desc 1"),
                    new Topic("2", "TopTwo", "somth desc 2"),
                    new Topic("3", "TopThree", "somth desc 3")
            )
    );

    public List<Topic> getListOfTopics() {
        return topics;
    }

    public Topic getTopic(String id) {
        Topic topic = getListOfTopics().stream().filter(t -> t.getId().equals(id)).findFirst().get();
        System.out.println(topic);

        return topic;
    }

    public void addTopic(Topic topic) {
        topics.add(topic);
    }

    public void updateTopic(String id, Topic topic) {
        for (Topic topic1 : topics) {
            if (topic1.getId().equals(id)) {
                topic1.setName(topic.getName());
                topic1.setDescription(topic.getDescription());
            }
        }
        return;
    }

    public void deleteTopic(String id) {
        topics.removeIf(t->t.getId().equals(id));

    }
}
