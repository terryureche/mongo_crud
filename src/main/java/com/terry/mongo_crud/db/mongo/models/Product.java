package com.terry.mongo_crud.db.mongo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.TextScore;

import java.util.List;

@Document(collection = "product")
public class Product {
    @Id
    private Integer id;

    @TextIndexed
    private String name;

    @DBRef
    private List<Subcategory> subcategoryList;

    @DBRef
    private List<Category> categoryList;

    @TextScore
    private Float textScore;

    public Product() {}

    public Product(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Product(Integer id, String name, List<Subcategory> subcategoryList, List<Category> categoryList) {
        this.id = id;
        this.name = name;
        this.subcategoryList = subcategoryList;
        this.categoryList = categoryList;
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

    public List<Subcategory> getSubcategoryList() {
        return subcategoryList;
    }

    public void setSubcategoryList(List<Subcategory> subcategoryList) {
        this.subcategoryList = subcategoryList;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public Float getTextScore() {
        return textScore;
    }

    public void setTextScore(Float textScore) {
        this.textScore = textScore;
    }
}
