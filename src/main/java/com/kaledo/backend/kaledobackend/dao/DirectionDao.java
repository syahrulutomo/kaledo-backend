/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaledo.backend.kaledobackend.dao;

import com.kaledo.backend.kaledobackend.entity.Direction;
import com.kaledo.backend.kaledobackend.entity.Recipe;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Syahrul
 */
public interface DirectionDao extends  PagingAndSortingRepository<Direction, Integer>{
    
    @Query("DELETE d FROM Direction d, Recipe r WHERE r.id_recipe = :idRecipe ")
    Recipe DeleteDirectionByIdRecipe( @Param("idRecipe") String idRecipe);
    
}
