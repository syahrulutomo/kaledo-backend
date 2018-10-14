/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaledo.backend.kaledobackend.controller;

import com.kaledo.backend.kaledobackend.dao.DirectionDao;
import com.kaledo.backend.kaledobackend.entity.Direction;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Syahrul
 */
@RestController
@RequestMapping(path="/api")
public class DirectionController {
    
     @Autowired
    private DirectionDao directionDao; 

    @RequestMapping(value="/direction", method = RequestMethod.GET)
    public Page<Direction> cariDirection(Pageable page) {         
        return directionDao.findAll(page);
        
    }
     
     @RequestMapping(value="/direction", method = RequestMethod.POST)
     @ResponseStatus(HttpStatus.CREATED)
     public void insertDirectionBaru(@RequestBody Direction d){
         directionDao.save(d);
     }
     
     @RequestMapping(value="/direction/{id}", method = RequestMethod.PUT)
     @ResponseStatus(HttpStatus.OK)
     public void updateDirection(@PathVariable("id") Integer id, @RequestBody Direction d){
         d.setId(id);
         directionDao.save(d);
     }
     
     @RequestMapping(value="/direction/{id}", method = RequestMethod.GET)
     @ResponseStatus(HttpStatus.OK)
     public Optional<Direction> findDirectionById(@PathVariable("id") Integer id){
         return directionDao.findById(id);
     }
     
     @RequestMapping(value="/direction/{id}", method = RequestMethod.DELETE)
     @ResponseStatus(HttpStatus.OK)
     public void hapusDirection(@PathVariable("id") Integer id){
         directionDao.deleteById(id);
     }
}
