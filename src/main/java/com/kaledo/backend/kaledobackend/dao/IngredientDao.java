/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaledo.backend.kaledobackend.dao;

import com.kaledo.backend.kaledobackend.entity.Ingredient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author timm
 */
public interface IngredientDao extends  PagingAndSortingRepository<Ingredient, Integer>{
    
    @Query("DELETE i FROM Ingredient i WHERE i.id_recipe = :idRecipe ")
    Void DeleteIngredientByTitle( @Param("idRecipe") String idRecipe);
    
}
