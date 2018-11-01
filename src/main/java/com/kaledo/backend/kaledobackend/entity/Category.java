/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaledo.backend.kaledobackend.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Syahrul
 */
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;   
    private String categoryName;
    
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "category") 
    private List<Recipe> recipeList = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Recipe> getRecipeList() {
        return recipeList;
    }

    public void setRecipeList(List<Recipe> recipeList) {
        this.recipeList = recipeList;
    }

   
    
    
}
