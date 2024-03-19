package com.student.kafka.service;

import com.student.kafka.consumer.KafkaConsumer;
import com.student.kafka.dto.Student;
import com.student.kafka.model.JsonEntity;
import com.student.kafka.repo.JsonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JsonStoreService {
    private JsonRepository jsonRepository;

    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);
    @Autowired
    public JsonStoreService(JsonRepository jsonRepository) {
        this.jsonRepository = jsonRepository;
    }

    public void saveJson(List<Student> message) {
        JsonEntity jsonEntity = new JsonEntity();
        jsonEntity.setJson(message);
        jsonRepository.save(jsonEntity);
        logger.info("Json message saved");
    }
}
