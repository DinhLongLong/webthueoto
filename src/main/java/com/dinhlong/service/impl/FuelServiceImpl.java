/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dinhlong.service.impl;

import com.dinhlong.pojos.Fuel;
import com.dinhlong.repository.FuelRepository;
import com.dinhlong.service.FuelService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class FuelServiceImpl implements FuelService {
    
    @Autowired
    private FuelRepository fuelRepository;

    @Override
    public List<Fuel> getFuels() {
        return this.fuelRepository.getFuels();
    }

    @Override
    public Fuel getFuelById(int id) {
        return this.fuelRepository.getFuelById(id);
    }
    
}
