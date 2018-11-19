/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaledo.backend.kaledobackend.dao;

import com.kaledo.backend.kaledobackend.entity.Recipe;
import com.kaledo.backend.kaledobackend.entity.User;
import java.util.Collection;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Syahrul
 */
public interface RecipeDao extends PagingAndSortingRepository<Recipe, Integer>{
    
    @Query("SELECT r FROM Recipe r WHERE r.title = :title ")
    Recipe findRecipeByTitle( @Param("title") String title);
    
    @Query("SELECT r FROM Recipe r WHERE r.user_email = :email ")
    Page findRecipeByUser( @Param("email") String email);
}
