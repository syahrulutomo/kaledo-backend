/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaledo.backend.kaledobackend.dao;

import com.kaledo.backend.kaledobackend.entity.Ingredient;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author timm
 */
public interface IngredientDao extends  PagingAndSortingRepository<Ingredient, Integer>{
    
}
