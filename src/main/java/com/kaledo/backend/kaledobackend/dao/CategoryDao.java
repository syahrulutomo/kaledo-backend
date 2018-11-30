/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaledo.backend.kaledobackend.dao;

import com.kaledo.backend.kaledobackend.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author Syahrul
 */
public interface CategoryDao extends PagingAndSortingRepository<Category,Integer> {
    
    @Query("SELECT c , r ,  u.firstName, u.lastName FROM Recipe r, Category c, User u "
            + "WHERE r = c.recipeList AND u = r.user")
    Page<Object> findRecipeAndUsers(Pageable page);

}
