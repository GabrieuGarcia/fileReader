package br.com.exercise.model;

import java.io.Serializable;

public class AbstractEntity implements Serializable {

    private String id;
    private String name;

    public AbstractEntity() {
    }

    public AbstractEntity(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
