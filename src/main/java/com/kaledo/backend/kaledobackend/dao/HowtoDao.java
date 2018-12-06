/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaledo.backend.kaledobackend.dao;


import com.kaledo.backend.kaledobackend.entity.Howto;
import com.kaledo.backend.kaledobackend.entity.Recipe;
import com.kaledo.backend.kaledobackend.entity.User;
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
public interface HowtoDao extends PagingAndSortingRepository<Howto, String>{
    
    @Query("SELECT h , u FROM Howto h JOIN h.user u")
    Page<Object> findHowtoAndUsers(Pageable page);
    
    public Page<Howto> findByUser(User u, Pageable page);
    String queryGetHowtoByUser = "select h from Howto h inner join h.user ";
    @Query(queryGetHowtoByUser)
    List<Howto> getHowtoByUser(User u, Pageable page);

}
