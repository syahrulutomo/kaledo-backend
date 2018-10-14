/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaledo.backend.kaledobackend.controller;

import com.kaledo.backend.kaledobackend.dao.UserDao;
import com.kaledo.backend.kaledobackend.entity.User;
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
    
    @RequestMapping(value="/user", method = RequestMethod.GET)
     public Page<User> cariUser(Pageable page) {         
         return userDao.findAll(page);
     }
     
     @RequestMapping(value="/user/login/", method = RequestMethod.GET)
     public User findByEmail(@RequestParam("email") String email,@RequestParam("password") String password){
        return userDao.findByEmailByPassword(email,password);
     }
     
     @RequestMapping(value="/user", method = RequestMethod.POST)
     @ResponseStatus(HttpStatus.CREATED)
     public void insertUserBaru(@RequestBody User u){
         userDao.save(u);
     }
     
     @RequestMapping(value="/user/{id}", method = RequestMethod.PUT)
     @ResponseStatus(HttpStatus.OK)
     public void updateUser(@PathVariable("id") Integer id, @RequestBody User u){
         u.setId(id);
         userDao.save(u);
     }
     
//     @RequestMapping(value="/user/{id}", method = RequestMethod.GET)
//     @ResponseStatus(HttpStatus.OK)
//     public User findUserById(@PathVariable("id") String id){
//         return userDao.findOne(id);
//     }
     
     @RequestMapping(value="/user/{id}", method = RequestMethod.DELETE)
     @ResponseStatus(HttpStatus.OK)
     public void hapusUser(@PathVariable("id") Integer id){
         userDao.deleteById(id);
     }
}
