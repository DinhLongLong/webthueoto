/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dinhlong.service;

import com.dinhlong.pojos.Product;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface ProductService {
    List<Product> getProducts();
    Product getProductById(int id);
    List<Product> getProductsByUserId(int userId);
    List<Product> getProductsByCategoryId(int categoryId);
    boolean addProduct(Product product);
    boolean deleteProduct(Product product);
}
