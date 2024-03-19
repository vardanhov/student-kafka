package com.student.kafka.service;

import com.student.kafka.dto.Student;
import com.student.kafka.model.JsonEntity;
import com.student.kafka.repo.JsonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JsonStoreService {
    private JsonRepository jsonRepository;

    @Autowired
    public JsonStoreService(JsonRepository jsonRepository) {
        this.jsonRepository = jsonRepository;
    }

    public void saveJson(List<Student> message) {
        JsonEntity jsonEntity = new JsonEntity();
        jsonEntity.setJson(message);
        jsonRepository.save(jsonEntity);
    }
}
