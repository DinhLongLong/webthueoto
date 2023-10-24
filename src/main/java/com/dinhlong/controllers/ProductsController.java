/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dinhlong.controllers;

import com.dinhlong.service.CategoryService;
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
public class ProductsController {
    
    @Autowired
    private CategoryService categoryService;
    
    @Autowired
    private ProductService productService;
    
    @RequestMapping("/products")
    public String productDetail(Model model,
            @RequestParam Map<String, String> params) {
        String categoryName = params.get("category");
        int categoryId = categoryService.getCategoryByCategoryName(categoryName).getId();
        model.addAttribute("products", productService.getProductsByCategoryId(categoryId));
        model.addAttribute("categories", this.categoryService.getCategories());
        model.addAttribute("categoryName", categoryName);
        
        return "products";
    }
}
