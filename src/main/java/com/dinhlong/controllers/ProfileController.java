/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dinhlong.controllers;

import com.dinhlong.service.CategoryService;
import com.dinhlong.service.FollowService;
import com.dinhlong.service.ProductService;
import com.dinhlong.service.UserService;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Admin
 */
@Controller
public class ProfileController {
    
    @Autowired
    private CategoryService categoryService;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private ProductService productService;
    
    @Autowired
    private FollowService followService;
    
    @RequestMapping("/profile/{username}")
    public String profile(Model model, 
            @PathVariable(value="username") String username) {
        model.addAttribute("user", this.userService.getUserByUsername(username));
        model.addAttribute("products", this.productService.getProductsByUserId(userService.getUserByUsername(username).getId()));
        model.addAttribute("follows", this.followService.getFollowsByFollowerId(userService.getUserByUsername(username).getId()));
        model.addAttribute("categories", this.categoryService.getCategories());
        return "profile";
    }
}
