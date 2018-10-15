/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaledo.backend.kaledobackend.controller;

import com.kaledo.backend.kaledobackend.dao.UserDao;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Syahrul
 */

@RestController
@RequestMapping(path="/api")
public class UserController {
    
    @Autowired
    private UserDao userDao;
    
    @RequestMapping(value="/users", method = RequestMethod.GET)
    public Page<User> cariCategory(Pageable page) {         
        return userDao.findAll(page);      
    }
     
    @RequestMapping(value="/users", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void insertUserBaru(@RequestBody User u){
        userDao.save(u);
    }
     
     @RequestMapping(value="/users/{email}", method = RequestMethod.PUT)
     @ResponseStatus(HttpStatus.OK)
     public void updateUser(@PathVariable("email") String email, @RequestBody User u){
         u.setEmail(email);
         userDao.save(u);
     }
     
     @RequestMapping(value="/users/{email}", method = RequestMethod.GET)
     @ResponseStatus(HttpStatus.OK)
     public Optional<User> findUserByEmail(@PathVariable("email") String email){
         return userDao.findById(email);
     }
     
     @RequestMapping(value="/users/{email}", method = RequestMethod.DELETE)
     @ResponseStatus(HttpStatus.OK)
     public void hapusUser(@PathVariable("email") String email){
         userDao.deleteById(email);
     }
}
