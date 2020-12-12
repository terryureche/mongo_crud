package com.terry.mongo_crud.db.mongo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.TextScore;

import java.util.List;

@Document
public class Subcategory {
    @Id
    private Integer id;
    @TextIndexed
    private String name;
    @DBRef
    private List<Category> categoryList;
    @TextScore
    private Float textScore;

    public Subcategory() {
    }

    public Subcategory(Integer id, String name, Integer categoryId) {
        this.id = id;
        this.name = name;
    }

    public Float getTextScore() {
        return textScore;
    }

    public void setTextScore(Float textScore) {
        this.textScore = textScore;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }
}
