package com.student.kafka.repo;

import com.student.kafka.model.JsonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JsonRepository extends JpaRepository<JsonEntity, Integer> {
}
