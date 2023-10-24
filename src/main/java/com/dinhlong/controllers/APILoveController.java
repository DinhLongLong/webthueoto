/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dinhlong.controllers;

import com.dinhlong.pojos.Love;
import com.dinhlong.pojos.Product;
import com.dinhlong.pojos.User;
import com.dinhlong.service.LoveService;
import com.dinhlong.service.ProductService;
import com.dinhlong.service.UserService;
import java.util.List;
import java.util.Map;
import org.apache.velocity.runtime.directive.Break;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Admin
 */
@RestController
public class APILoveController {
    @Autowired
    private LoveService loveService;
    
    @Autowired
    private UserService userService;
            
    @Autowired
    private ProductService productService;
    
//    ADD LOVE
    @PostMapping(path = "/api/user/add-love", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Love> addLove(@RequestBody Map<String, String> params) {
        String username = params.get("username");
        String productId = params.get("productId");
        
        Love love = new Love();
        
        User user = this.userService.getUserByUsername(username);
        love.setUser(user);
        
        Product product = this.productService.getProductById(Integer.parseInt(productId));
        love.setProduct(product);
        
        Boolean isSuccess = this.loveService.addLove(love);
        
        if (isSuccess) {
            return new ResponseEntity<>(love, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    
//    DELETE LOVE
    @PostMapping(path = "/api/user/delete-love", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Object> deleteLove(@RequestBody Map<String, String> params) {
        String username = params.get("username");
        String productId = params.get("productId");
        
        List<Love> loves = loveService.getLovesByProductId(Integer.parseInt(productId));

        for (Love love : loves) {
            if (love.getUser().getUsername().equals(username)) {
                return new ResponseEntity<>(loveService.deleteLove(love.getId()), HttpStatus.OK);
            };
        };
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    };
};
