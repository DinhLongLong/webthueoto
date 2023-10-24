/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dinhlong.service.impl;

import com.dinhlong.pojos.Product;
import com.dinhlong.repository.ProductRepository;
import com.dinhlong.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class ProductServiceImpl implements ProductService {
    
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getProducts() {
        return this.productRepository.getProducts();
    }

    @Override
    public Product getProductById(int id) {
        return this.productRepository.getProductById(id);
    }

    @Override
    public List<Product> getProductsByUserId(int userId) {
        return this.productRepository.getProductsByUserId(userId);
    }

    @Override
    public List<Product> getProductsByCategoryId(int categoryId) {
        return this.productRepository.getProductsByCategoryId(categoryId);
    }

    @Override
    public boolean addProduct(Product product) {
        return this.productRepository.addProduct(product);
    }

    @Override
    public boolean deleteProduct(Product product) {
        return this.productRepository.deleteProduct(product);
    }

}
