/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaledo.backend.kaledobackend.controller;

import com.kaledo.backend.kaledobackend.dao.RecipeDao;
import com.kaledo.backend.kaledobackend.dao.UserDao;
import com.kaledo.backend.kaledobackend.entity.Category;
import com.kaledo.backend.kaledobackend.entity.Direction;
import com.kaledo.backend.kaledobackend.entity.Howto;
import com.kaledo.backend.kaledobackend.entity.Ingredient;
import com.kaledo.backend.kaledobackend.entity.Recipe;
import com.kaledo.backend.kaledobackend.entity.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Syahrul
 */

@RestController
@RequestMapping(path="/api")
public class RecipeController {

    @Autowired
    private RecipeDao recipeDao; 
    
    @Autowired
    private UserDao userDao; 

    @RequestMapping(value="/recipe", method = RequestMethod.GET)
    public Page<Recipe> cariRecipe(Pageable page) {         
       return recipeDao.findAll(page);      
    }
     
    @RequestMapping(value="/recipe/user{email}", method = RequestMethod.GET)
    public Page<Recipe> findHowtoByUser(Pageable page,@PathVariable("email") String email){
        User u = new User();
        u.setEmail(email);
        
        return recipeDao.findByUser(u, page);
    }
    
     @RequestMapping(value="/recipe/category{idCategory}/user{email}", method = RequestMethod.POST)
     @ResponseStatus(HttpStatus.CREATED)
     public void insertRecipeBaru(@RequestBody Recipe r, @PathVariable("idCategory") Integer idCategory,
             @PathVariable("email") String email){
        Category c = new Category();
        c.setId(idCategory);
        
        User u = new User();
        u.setEmail(email);
        
        r.setCategory(c);
        r.setUser(u);
                
        recipeDao.save(r);
     }
     
     @RequestMapping(value="/recipe/{id}", method = RequestMethod.PUT)
     @ResponseStatus(HttpStatus.OK)
     public void updateRecipe(@PathVariable("id") Integer id, @RequestBody Recipe r){
         r.setId(id);
         recipeDao.save(r);
     }
     
     @RequestMapping(value="/recipe/{id}", method = RequestMethod.GET)
     @ResponseStatus(HttpStatus.OK)
     public Optional<Recipe> findRecipeById(@PathVariable("id") Integer id){
         return recipeDao.findById(id);
     }
     
     @RequestMapping(value="/recipe/title{title}/user{email}", method = RequestMethod.GET)
     @ResponseStatus(HttpStatus.OK)
     public Recipe findUserRecipe(@PathVariable("title") String title,
             @PathVariable("email") String email){
         return userDao.findUserRecipe(title, email);
     }
     
     @RequestMapping(value="/recipe/{id}", method = RequestMethod.DELETE)
     @ResponseStatus(HttpStatus.OK)
     public void hapusRecipe(@PathVariable("id") Integer id){
         recipeDao.deleteById(id);
     }
}
