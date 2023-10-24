/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dinhlong.controllers;

import com.dinhlong.service.CategoryService;
import com.dinhlong.service.CommentService;
import com.dinhlong.service.FollowService;
import com.dinhlong.service.LoveService;
import com.dinhlong.service.ProductService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Admin
 */
@Controller
public class ProductDetailController {
    
    @Autowired
    private CategoryService categoryService;
    
    @Autowired
    private ProductService productService;
    
    @Autowired
    private CommentService commentService;
    
    @Autowired
    private LoveService loveService;
    
    @RequestMapping("/product-detail")
    public String productDetail(Model model,
            @RequestParam Map<String, String> params) {
        int productId = Integer.parseInt(params.get("product-id"));      
        model.addAttribute("product", this.productService.getProductById(productId));
        model.addAttribute("comments", this.commentService.getCommentsByProductId(productId));
        model.addAttribute("loves", this.loveService.getLovesByProductId(productId));
        model.addAttribute("categories", this.categoryService.getCategories());
        
        return "productDetail";
    }
}
