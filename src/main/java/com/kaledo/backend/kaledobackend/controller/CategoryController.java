/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaledo.backend.kaledobackend.controller;

import com.kaledo.backend.kaledobackend.dao.CategoryDao;
import com.kaledo.backend.kaledobackend.entity.Category;
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
public class CategoryController {
    
    @Autowired
    private CategoryDao categoryDao; 

    @RequestMapping(value="/category", method = RequestMethod.GET)
    public Page<Category> cariCategory(Pageable page) {         
        return categoryDao.findAll(page);
        
    }
     
     @RequestMapping(value="/category", method = RequestMethod.POST)
     @ResponseStatus(HttpStatus.CREATED)
     public void insertCategoryBaru(@RequestBody Category c){
         categoryDao.save(c);
     }
     
     @RequestMapping(value="/category/{id}", method = RequestMethod.PUT)
     @ResponseStatus(HttpStatus.OK)
     public void updateCategory(@PathVariable("id") Integer id, @RequestBody Category c){
         c.setId(id);
         categoryDao.save(c);
     }
     
     @RequestMapping(value="/category/{id}", method = RequestMethod.GET)
     @ResponseStatus(HttpStatus.OK)
     public Optional<Category> findCategoryById(@PathVariable("id") Integer id){
         return categoryDao.findById(id);
     }
     
     @RequestMapping(value="/category/{id}", method = RequestMethod.DELETE)
     @ResponseStatus(HttpStatus.OK)
     public void hapusCategory(@PathVariable("id") Integer id){
         categoryDao.deleteById(id);
     }
}
