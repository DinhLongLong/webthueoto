/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dinhlong.controllers;

import com.dinhlong.pojos.Product;
import com.dinhlong.service.BrandService;
import com.dinhlong.service.CategoryService;
import com.dinhlong.service.ColorService;
import com.dinhlong.service.FuelService;
import com.dinhlong.service.GearboxService;
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
public class APIAddProductController {
    
    @Autowired
    private ProductService productService;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private CategoryService categoryService;
    
    @Autowired
    private BrandService brandService;
    
    @Autowired
    private ColorService colorService;
    
    @Autowired
    private FuelService fuelService;
    
    @Autowired
    private GearboxService gearboxService;
    
    @PostMapping(path = "/api/user/add-product", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Product> addProduct(@RequestBody Map<String, String> params) {
        String username = params.get("username");
        String category = params.get("category");
        String brand = params.get("brand");
        String color = params.get("color");
        String gearbox = params.get("gearbox");
        String fuel = params.get("fuel");
        String name = params.get("name");
        String img = params.get("img");
        String licensePlate = params.get("licensePlate");      
        String price = params.get("price");
        String description = params.get("description");
        
        Product product = new Product();  
        product.setUser(this.userService.getUserByUsername(username));   
        product.setCategory(this.categoryService.getCategoryById(Integer.parseInt(category)));   
        product.setBrand(this.brandService.getBrandById(Integer.parseInt(brand)));
        product.setColor(this.colorService.getColorById(Integer.parseInt(color)));    
        product.setGearbox(this.gearboxService.getGearboxById(Integer.parseInt(gearbox)));   
        product.setFuel(this.fuelService.getFuelById(Integer.parseInt(fuel))); 
        product.setName(name);
        product.setImg(img);
        product.setLicensePlate(licensePlate);
        product.setPrice(price);
        product.setDescription(description);
        
        Boolean isSuccess = this.productService.addProduct(product);
        
        if (isSuccess) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }  
}
