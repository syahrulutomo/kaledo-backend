/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaledo.backend.kaledobackend.controller;

import com.kaledo.backend.kaledobackend.dao.ArticleDao;
import com.kaledo.backend.kaledobackend.dao.DirectionDao;
import com.kaledo.backend.kaledobackend.entity.Article;
import com.kaledo.backend.kaledobackend.entity.Direction;
import com.kaledo.backend.kaledobackend.entity.Howto;
import com.kaledo.backend.kaledobackend.entity.Recipe;
import java.util.Optional;
import javax.persistence.Entity;
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
public class ArticleController {
    
    @Autowired
    private ArticleDao articleDao; 

    @RequestMapping(value="/article", method = RequestMethod.GET)
    public Page<Article> cariArticle(Pageable page) {         
        return articleDao.findAll(page);
        
    }
     
     @RequestMapping(value="/article/howto/{id_howto}", method = RequestMethod.POST)
     @ResponseStatus(HttpStatus.CREATED)
     public void insertArticleBaru(@RequestBody Article a , @PathVariable("id_howto") String idHowto){
        Howto h = new Howto();
        h.setId(idHowto);
         
        a.setHowto(h);
        articleDao.save(a);
     }
     
     @RequestMapping(value="/article/{id}", method = RequestMethod.PUT)
     @ResponseStatus(HttpStatus.OK)
     public void updateArticle(@PathVariable("id") Integer id, @RequestBody Article a){
        a.setId(id);
        articleDao.save(a);
     }
     
     @RequestMapping(value="/article/{id}", method = RequestMethod.GET)
     @ResponseStatus(HttpStatus.OK)
     public Optional<Article> findArticleById(@PathVariable("id") Integer id){
        return articleDao.findById(id);
     }
     
     @RequestMapping(value="/article/{id}", method = RequestMethod.DELETE)
     @ResponseStatus(HttpStatus.OK)
     public void hapusDirection(@PathVariable("id") Integer id){
        articleDao.deleteById(id);
     }
     
}
