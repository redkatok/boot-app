package app.core.repo;

import app.core.dto.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends JpaRepository<Topic,Long> {

    //getAllTopics
    //getTopic(String id)
    //updateTopic(Topic t)
    //delete(String id)


}
