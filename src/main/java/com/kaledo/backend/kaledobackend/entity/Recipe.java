/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaledo.backend.kaledobackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Syahrul
 */
@Entity
public class Recipe {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category category;
    
    private String subCategory;
    private String title;
    
    @Column(columnDefinition="text")
    private String description;
    
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "recipe") 
    private List<Direction> directionList = new ArrayList<>();
    
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "recipe") 
    private List<Ingredient> ingredirentList = new ArrayList<>();
  
    private String photos;
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_email")
    private User user;
    private String time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public List<Direction> getDirectionList() {
        return directionList;
    }

    public void setDirectionList(List<Direction> directionList) {
        this.directionList = directionList;
    }

    public List<Ingredient> getIngredirentList() {
        return ingredirentList;
    }

    public void setIngredirentList(List<Ingredient> ingredirentList) {
        this.ingredirentList = ingredirentList;
    }

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
