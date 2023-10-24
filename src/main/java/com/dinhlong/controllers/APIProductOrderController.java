/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dinhlong.controllers;

import com.dinhlong.pojos.Product;
import com.dinhlong.pojos.ProductOrder;
import com.dinhlong.pojos.User;
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
import com.dinhlong.service.ProductOrderService;

/**
 *
 * @author Admin
 */
@RestController
public class APIProductOrderController {
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private ProductService productService;
    
    @Autowired
    private ProductOrderService productOrderService;
    
    @PostMapping(path = "/api/user/product-order", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<ProductOrder> addProductOrder(@RequestBody Map<String, String> params) {
        String username = params.get("username");
        String ownername = params.get("ownername");
        String productId = params.get("productId");
        String timeDay = params.get("timeDay");
        String note = params.get("note");
        
        ProductOrder productOrder = new ProductOrder();
        
        User user = this.userService.getUserByUsername(username);
        productOrder.setUser(user);
        
        User owner = this.userService.getUserByUsername(ownername);
        productOrder.setOwner(owner);
        
        Product product = this.productService.getProductById(Integer.parseInt(productId));
        productOrder.setProduct(product);
        
        productOrder.setTimeDay(timeDay);
        productOrder.setNote(note);
        productOrder.setConfirmStatus("pending");
        
        Boolean isSuccess = this.productOrderService.addProductOrder(productOrder);
        
        if (isSuccess) {
            return new ResponseEntity<>(productOrder, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
