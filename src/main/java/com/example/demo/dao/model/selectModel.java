package com.example.demo.dao.model;

import java.io.Serializable;

public class selectModel implements Serializable {
    int id;
    String text;

    public void setId(int id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }
}
