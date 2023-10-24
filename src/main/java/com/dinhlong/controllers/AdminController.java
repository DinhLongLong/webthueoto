/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dinhlong.controllers;

import com.dinhlong.service.CategoryService;
import com.dinhlong.service.ProductOrderService;
import com.dinhlong.service.ProductService;
import com.dinhlong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author AdminController
 */
@Controller
public class AdminController {
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private ProductService productService;
    
    @Autowired
    private ProductOrderService productOrderService;
    
    @Autowired
    private CategoryService categoryService;
    
    @RequestMapping("/admin/manage")
    public String index(Model model) {
        model.addAttribute("users", this.userService.getUsers());
        model.addAttribute("products", this.productService.getProducts());
        model.addAttribute("productOrders", this.productOrderService.getProductOrders());
        model.addAttribute("categories", this.categoryService.getCategories());
        
        return "admin";
    }   
    
}
