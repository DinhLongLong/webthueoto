/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dinhlong.service.impl;

import com.dinhlong.pojos.Gearbox;
import com.dinhlong.repository.GearboxRepository;
import com.dinhlong.service.GearboxService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class GearboxServiceImpl implements GearboxService {
    
    @Autowired
    private GearboxRepository gearboxRepository;

    @Override
    public List<Gearbox> getGearboxs() {
        return this.gearboxRepository.getGearboxs();
    }

    @Override
    public Gearbox getGearboxById(int id) {
        return this.gearboxRepository.getGearboxById(id);
    }
    
}
