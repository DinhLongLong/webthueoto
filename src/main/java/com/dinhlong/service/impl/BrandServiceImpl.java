/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dinhlong.service.impl;

import com.dinhlong.pojos.Brand;
import com.dinhlong.repository.BrandRepository;
import com.dinhlong.service.BrandService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class BrandServiceImpl implements BrandService {
    
    @Autowired
    private BrandRepository brandRepository;

    @Override
    public List<Brand> getBrands() {
        return this.brandRepository.getBrands();
    }

    @Override
    public Brand getBrandById(int id) {
        return this.brandRepository.getBrandById(id);
    }
    
}
