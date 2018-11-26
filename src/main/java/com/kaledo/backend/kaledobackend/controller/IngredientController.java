/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaledo.backend.kaledobackend.controller;

import com.kaledo.backend.kaledobackend.dao.IngredientDao;
import com.kaledo.backend.kaledobackend.entity.Ingredient;
import com.kaledo.backend.kaledobackend.entity.Recipe;
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
public class IngredientController {
    
    @Autowired
    private IngredientDao ingredientDao; 

    @RequestMapping(value="/ingredient", method = RequestMethod.GET)
    public Page<Ingredient> cariIngredient(Pageable page) {         
        return ingredientDao.findAll(page);
    }
     
     @RequestMapping(value="/ingredient/recipe{id_recipe}", method = RequestMethod.POST)
     @ResponseStatus(HttpStatus.CREATED)
     public void insertIngredientBaru(@RequestBody Ingredient i, @PathVariable("id_recipe") String idRecipe){
         Recipe r = new Recipe();
         r.setId(idRecipe);
         
         i.setRecipe(r);
         ingredientDao.save(i);
     }
     
     @RequestMapping(value="/ingredient/{id}", method = RequestMethod.PUT)
     @ResponseStatus(HttpStatus.OK)
     public void updateIngredient(@PathVariable("id") Integer id, @RequestBody Ingredient i){
         i.setId(id);
         ingredientDao.save(i);
     }
     
     @RequestMapping(value="/ingredient/{id}", method = RequestMethod.GET)
     @ResponseStatus(HttpStatus.OK)
     public Optional<Ingredient> findIngredientById(@PathVariable("id") Integer id){
         return ingredientDao.findById(id);
     }
     
     @RequestMapping(value="/ingredient/{id}", method = RequestMethod.DELETE)
     @ResponseStatus(HttpStatus.OK)
     public void hapusIngredient(@PathVariable("id") Integer id){
         ingredientDao.deleteById(id);
     }
}
