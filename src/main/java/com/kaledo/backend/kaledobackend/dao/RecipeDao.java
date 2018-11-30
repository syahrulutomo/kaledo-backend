/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaledo.backend.kaledobackend.dao;

import com.kaledo.backend.kaledobackend.entity.Category;
import com.kaledo.backend.kaledobackend.entity.Howto;
import com.kaledo.backend.kaledobackend.entity.Recipe;
import com.kaledo.backend.kaledobackend.entity.User;
import java.util.Collection;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Syahrul
 */
public interface RecipeDao extends PagingAndSortingRepository<Recipe, String>{
    
    @Query("SELECT r FROM Recipe r WHERE r.title = :title ")
    Recipe findRecipeByTitle( @Param("title") String title);
    
    @Query("SELECT r,u FROM Recipe r, User u WHERE u = r.user")
    Page<Object> findRecipeAndUsers(Pageable page);
    
    public Page<Recipe> findByUser(User u, Pageable page);
    String queryGetRecipeByUser = "select r from Recipe r inner join r.user ";
    @Query(queryGetRecipeByUser)
    List<Recipe> getRecipeByUser(User u, Pageable page);
}
