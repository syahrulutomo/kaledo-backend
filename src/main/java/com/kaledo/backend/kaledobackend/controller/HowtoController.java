/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaledo.backend.kaledobackend.controller;

import com.kaledo.backend.kaledobackend.dao.HowtoDao;
import com.kaledo.backend.kaledobackend.dao.UserDao;
import com.kaledo.backend.kaledobackend.entity.Howto;
import com.kaledo.backend.kaledobackend.entity.Recipe;
import com.kaledo.backend.kaledobackend.entity.User;
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
    
    @Autowired
    private UserDao ud;
    
    @RequestMapping(value="/howto", method = RequestMethod.GET)
    public Page<Howto> cariHowto(Pageable page) {         
        return hd.findAll(page);      
    }
     
    @RequestMapping(value="/howto/user{email}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void insertHowtoBaru(@RequestBody Howto h, @PathVariable("email") String email){
        User u = new User();
        u.setEmail(email);
        
        h.setUser(u);
        hd.save(h);
    }
     
    @RequestMapping(value="/howto{id}/user{email}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
     public void updateHowto(@PathVariable("id") String id, @RequestBody Howto h,
             @PathVariable("email") String email){
        User u = new User();
        u.setEmail(email);
        
        h.setUser(u);
        h.setId(id);
        hd.save(h);
     }
     
    @RequestMapping(value="/howto/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Optional<Howto> findHowtoById(@PathVariable("id") String id){
        return hd.findById(id);
    }
    
    
     @RequestMapping(value="/howto/title{title}/user{email}", method = RequestMethod.GET)
     @ResponseStatus(HttpStatus.OK)
     public Howto findUserHowtoByTitle(@PathVariable("title") String title,
             @PathVariable("email") String email){
         return ud.findUserHowto(title, email);
     }
     
     @RequestMapping(value="/howto/user{email}", method = RequestMethod.GET)
     public Page<Howto> findHowtoByUser(Pageable page,@PathVariable("email") String email){
        User u = new User();
        u.setEmail(email);
         
         return hd.findByUser(u, page);
     }
     
     @RequestMapping(value="/howto/{id}", method = RequestMethod.DELETE)
     @ResponseStatus(HttpStatus.OK)
     public void hapusUser(@PathVariable("id") String id){
        hd.deleteById(id);
     }
}
