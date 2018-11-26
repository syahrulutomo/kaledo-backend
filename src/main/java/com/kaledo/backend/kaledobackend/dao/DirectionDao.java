/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaledo.backend.kaledobackend.dao;

import com.kaledo.backend.kaledobackend.entity.Direction;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author Syahrul
 */
public interface DirectionDao extends  PagingAndSortingRepository<Direction, Integer>{
      
}
