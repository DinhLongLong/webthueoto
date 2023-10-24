/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dinhlong.service.impl;

import com.dinhlong.pojos.Love;
import com.dinhlong.repository.LoveRepository;
import com.dinhlong.service.LoveService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class LoveServiceImpl implements LoveService {
    
    @Autowired
    private LoveRepository loveRepository;

    @Override
    public List<Love> getLovesByProductId(int productId) {
        return this.loveRepository.getLovesByProductId(productId);
    }

    @Override
    public boolean addLove(Love love) {
        return this.loveRepository.addLove(love);
    } 

    @Override
    public Love getLoveById(int id) {
        return this.loveRepository.getLoveById(id);
    }

    @Override
    public boolean deleteLove(int id) {
        return this.loveRepository.deleteLove(id);
    }

    @Override
    public List<Love> getLovesByUserId(int userId) {
        return this.loveRepository.getLovesByUserId(userId);
    }
}
