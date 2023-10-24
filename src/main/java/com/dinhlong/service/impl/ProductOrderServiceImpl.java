/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dinhlong.service.impl;

import com.dinhlong.pojos.ProductOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dinhlong.repository.ProductOrderRepository;
import com.dinhlong.service.ProductOrderService;
import java.util.List;

/**
 *
 * @author Admin
 */
@Service
public class ProductOrderServiceImpl implements ProductOrderService {
    
    @Autowired
    private ProductOrderRepository productOrderRepository;

    @Override
    public boolean addProductOrder(ProductOrder productOrder) {
        return this.productOrderRepository.addProductOrder(productOrder);
    }

    @Override
    public List<ProductOrder> getProductOrders() {
        return this.productOrderRepository.getProductOrders();
    }

    @Override
    public ProductOrder getProductOrderById(int id) {
        return this.productOrderRepository.getProductOrderById(id);
    }

    @Override
    public boolean updateProductOrder(ProductOrder productOrder) {
        return this.productOrderRepository.updateProductOrder(productOrder);
    }

    @Override
    public boolean deleteProductOrder(ProductOrder productOrder) {
        return this.productOrderRepository.deleteProductOrder(productOrder);
    }

}
