/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaledo.backend.kaledobackend.entity;

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
import javax.persistence.Table;

/**
 *
 * @author Syahrul
 */

@Entity
@Table(name = "users")
public class User {
    
    private String firstName;
    private String lastName;
    
    @Id
    @Column(nullable = false)
    private String email;
    private String password;
    private String profilPicture;
    
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user") 
    private List<Recipe> recipeList = new ArrayList<>();
    
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user") 
    private List<Howto> howtoList = new ArrayList<>();
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfilPicture() {
        return profilPicture;
    }

    public void setProfilPicture(String profilPicture) {
        this.profilPicture = profilPicture;
    }

    public List<Recipe> getRecipeList() {
        return recipeList;
    }

    public void setRecipeList(List<Recipe> recipeList) {
        this.recipeList = recipeList;
    }

    public List<Howto> getHowtoList() {
        return howtoList;
    }

    public void setHowtoList(List<Howto> howtoList) {
        this.howtoList = howtoList;
    }

    
   
   
   
    
    
    
}
