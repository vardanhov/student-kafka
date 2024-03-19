package com.student.kafka.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.student.kafka.constant.ApplicationConstant;
import com.student.kafka.dto.Student;
import com.student.kafka.service.JsonStoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class KafkaConsumer {
    private JsonStoreService jsonStoreService;

    @Autowired
    public KafkaConsumer(JsonStoreService jsonStoreService) {
        this.jsonStoreService = jsonStoreService;
    }

    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(groupId = ApplicationConstant.GROUP_ID_JSON, topics = ApplicationConstant.TOPIC_NAME, containerFactory = ApplicationConstant.KAFKA_LISTENER_CONTAINER_FACTORY)
    public void receivedMessage(List<Student> message) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(message);
        logger.info("Json message received using Kafka listener " + jsonString);

        jsonStoreService.saveJson(message);
    }
}
