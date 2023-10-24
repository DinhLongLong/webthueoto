/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dinhlong.controllers;

import com.dinhlong.service.BrandService;
import com.dinhlong.service.ColorService;
import com.dinhlong.service.FuelService;
import com.dinhlong.service.GearboxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.dinhlong.service.CategoryService;

/**
 *
 * @author Admin
 */
@Controller
public class AddProductController {
    
    @Autowired
    private BrandService brandService;
    
    @Autowired
    private ColorService colorService;
    
    @Autowired
    private FuelService fuelService;
    
    @Autowired
    private GearboxService gearboxService;
    
    @Autowired
    private CategoryService categoryService;
    
    @RequestMapping("/user/{username}/add-product")
    public String profile(Model model, 
            @PathVariable(value="username") String username) {
        model.addAttribute("brands", brandService.getBrands());
        model.addAttribute("colors", colorService.getColors());
        model.addAttribute("fuels", fuelService.getFuels());
        model.addAttribute("gearboxs", gearboxService.getGearboxs());
        model.addAttribute("categories", categoryService.getCategories());

        return "addProduct";
    }
}
