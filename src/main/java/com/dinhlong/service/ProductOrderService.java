/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dinhlong.service;

import com.dinhlong.pojos.ProductOrder;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface ProductOrderService {
    boolean addProductOrder(ProductOrder productOrder);
    List<ProductOrder> getProductOrders();
    ProductOrder getProductOrderById(int id);
    boolean updateProductOrder(ProductOrder productOrder);
    boolean deleteProductOrder(ProductOrder productOrder);
}
