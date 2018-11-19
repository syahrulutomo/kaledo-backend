/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaledo.backend.kaledobackend.dao;


import com.kaledo.backend.kaledobackend.entity.Howto;
import com.kaledo.backend.kaledobackend.entity.Recipe;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Syahrul
 */
public interface HowtoDao extends PagingAndSortingRepository<Howto, Integer>{
    
    @Query("SELECT h FROM Howto h WHERE h.user_email = :email ")
    Page findHowtoByUser( @Param("email") String email);

}
