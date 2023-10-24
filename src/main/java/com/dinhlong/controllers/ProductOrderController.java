/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dinhlong.controllers;

import com.dinhlong.service.CategoryService;
import com.dinhlong.service.ProductService;
import com.dinhlong.service.UserService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Admin
 */
@Controller
public class ProductOrderController {
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private ProductService productService;
    
    @Autowired
    private CategoryService categoryService;
    
    @RequestMapping("/user/{username}/product-order")
    public String profile(Model model, 
            @PathVariable(value="username") String username,
            @RequestParam Map<String, String> params) {
        int productId = Integer.parseInt(params.get("product-id"));
        model.addAttribute("user", this.userService.getUserByUsername(username));
        model.addAttribute("product", productService.getProductById(productId));
        model.addAttribute("categories", categoryService.getCategories());
        
        return "productOrder";
    }
}
