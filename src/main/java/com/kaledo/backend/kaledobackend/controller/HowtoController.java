/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaledo.backend.kaledobackend.controller;

import com.kaledo.backend.kaledobackend.dao.HowtoDao;
import com.kaledo.backend.kaledobackend.entity.Howto;
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
public class HowtoController {
    
    @Autowired
    private HowtoDao hd;
    
    @RequestMapping(value="/howto", method = RequestMethod.GET)
    public Page<Howto> cariHowto(Pageable page) {         
        return hd.findAll(page);      
    }
     
    @RequestMapping(value="/howto", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void insertHowtoBaru(@RequestBody Howto h){
        hd.save(h);
    }
     
    @RequestMapping(value="/howto/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
     public void updateHowto(@PathVariable("id") Integer id, @RequestBody Howto h){
        h.setId(id);
        hd.save(h);
     }
     
    @RequestMapping(value="/howto/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Optional<Howto> findCategoryById(@PathVariable("id") Integer id){
        return hd.findById(id);
    }
     
     @RequestMapping(value="/howto/{id}", method = RequestMethod.DELETE)
     @ResponseStatus(HttpStatus.OK)
     public void hapusUser(@PathVariable("id") Integer id){
        hd.deleteById(id);
     }
}