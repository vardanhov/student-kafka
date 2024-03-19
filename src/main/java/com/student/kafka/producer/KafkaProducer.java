package com.student.kafka.producer;

import com.student.kafka.constant.ApplicationConstant;
import com.student.kafka.dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class KafkaProducer {
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Autowired
    public KafkaProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @EventListener(ApplicationReadyEvent.class)
    public String sendMessage( ) {
        List<Student> list = new ArrayList<>();
        list.add(new Student(1,"Aram"));
        list.add(new Student(2,"Lilit"));
        try {
            kafkaTemplate.send(ApplicationConstant.TOPIC_NAME, list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "json message sent succuessfully";
    }

}