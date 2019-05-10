package com.example.demo.entity;

import org.springframework.data.mongodb.core.mapping.Field;

public class person {
    private String name;
    @Field("id")
    private String id;

    public String getName() {
        return name;
    }

    public person(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
