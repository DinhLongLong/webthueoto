/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dinhlong.controllers;

import com.dinhlong.pojos.Love;
import com.dinhlong.pojos.Product;
import com.dinhlong.pojos.User;
import com.dinhlong.service.CategoryService;
import com.dinhlong.service.FollowService;
import com.dinhlong.service.LoveService;
import com.dinhlong.service.ProductService;
import com.dinhlong.service.UserService;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.inject.Produces;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Admin
 */
@Controller
public class UserController {
    
    @Autowired
    private CategoryService categoryService;
    
    @Autowired
    private UserService userDetailsService;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private ProductService productService;
    
    @Autowired
    private LoveService loveService;
    
    @Autowired
    private FollowService followService;
    
    
    @RequestMapping("/user/{username}")
    public String profile(Model model, 
            @PathVariable(value="username") String username) {
        
        List<Product> loveProducts = new ArrayList<>();
        this.loveService.getLovesByUserId(userService.getUserByUsername(username).getId()).forEach(l -> {
            loveProducts.add(l.getProduct());
        });
        
        model.addAttribute("user", this.userService.getUserByUsername(username));
        model.addAttribute("products", this.productService.getProductsByUserId(userService.getUserByUsername(username).getId()));
        model.addAttribute("loveProducts", loveProducts);
        model.addAttribute("categories", this.categoryService.getCategories());
        model.addAttribute("follows", this.followService.getFollowsByUserId(userService.getUserByUsername(username).getId()));
        
        return "user";
    }
    
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("categories", this.categoryService.getCategories());
        
        return "login";
    }
    
    @GetMapping("/register")
    public String registerView(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("categories", this.categoryService.getCategories());
        
        return "register";
    }
    
    @PostMapping("/register")
    public String register(Model model, @ModelAttribute(value = "user") User user) {
        String errorMessage = "";
        if (user.getPassword().equals(user.getConfirmPassword())) {
            errorMessage = user.getName();
            if (userDetailsService.addUser(user) == true) {
                errorMessage = user.getName();
                return("redirect:/login");
            } else {
                errorMessage = "Lỗi đăng ký";
            }
        } else {
            errorMessage = "Mật khẩu không trùng khớp";
        }
        model.addAttribute("errorMessage", errorMessage);
        model.addAttribute("categories", this.categoryService.getCategories());
        
        return "register";
    }
    
}

