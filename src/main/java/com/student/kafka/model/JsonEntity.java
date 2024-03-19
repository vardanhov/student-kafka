package com.student.kafka.model;


import com.student.kafka.dto.Student;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "json_store")
@TypeDef(
        name = "jsonb", typeClass = JsonBinaryType.class
)
public class JsonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private List<Student> json;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Student> getJson() {
        return json;
    }

    public void setJson(List<Student> json) {
        this.json = json;
    }

}
