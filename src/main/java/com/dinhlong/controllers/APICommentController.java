/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dinhlong.controllers;

import com.dinhlong.pojos.Comment;
import com.dinhlong.pojos.Product;
import com.dinhlong.pojos.User;
import com.dinhlong.service.CommentService;
import com.dinhlong.service.ProductService;
import com.dinhlong.service.UserService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Admin
 */
@RestController
public class APICommentController {
    
    @Autowired
    private CommentService commentService;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private ProductService productService;
    
    @PostMapping(path = "/api/user/add-comment", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Comment> addComment(@RequestBody Map<String, String> params) {
        String username = params.get("username");
        String productId = params.get("productId");
        String content = params.get("content");
        
        Comment comment = new Comment();
        
        comment.setContent(content);
        
        User user = this.userService.getUserByUsername(username);
        comment.setUser(user);
        
        Product product = this.productService.getProductById(Integer.parseInt(productId));
        comment.setProduct(product);
        
        Boolean isSuccess = this.commentService.addComment(comment);
        
        if (isSuccess) {
            return new ResponseEntity<>(comment, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }  
}
