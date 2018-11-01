/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaledo.backend.kaledobackend.dao;

import com.kaledo.backend.kaledobackend.entity.Recipe;
import com.kaledo.backend.kaledobackend.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Syahrul
 */
public interface UserDao extends PagingAndSortingRepository<User, String>{
    
    @Query("SELECT r FROM User u, Recipe r WHERE r.title = :title and u.email = :email")
    Recipe findUserRecipe( @Param("title") String title ,@Param("email") String email);
    
    @Query("SELECT h FROM User u, Howto h WHERE h.title = :title and u.email = :email")
    Howto findUserHowto( @Param("title") String title ,@Param("email") String email);
}
