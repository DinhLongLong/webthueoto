/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dinhlong.service.impl;

import com.dinhlong.pojos.Color;
import com.dinhlong.repository.ColorRepository;
import com.dinhlong.service.ColorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class ColorServiceImpl implements ColorService {
    
    @Autowired
    private ColorRepository colorRepository;

    @Override
    public List<Color> getColors() {
        return this.colorRepository.getColors();
    }

    @Override
    public Color getColorById(int id) {
        return this.colorRepository.getColorById(id);
    }
    
}
