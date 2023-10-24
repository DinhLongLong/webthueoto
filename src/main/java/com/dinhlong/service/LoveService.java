/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dinhlong.service;

import com.dinhlong.pojos.Love;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface LoveService {
    List<Love> getLovesByProductId(int productId);
    List<Love> getLovesByUserId(int userId);
    boolean addLove(Love love);
    Love getLoveById(int id);
    boolean deleteLove(int id);
}
