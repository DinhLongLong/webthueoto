/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dinhlong.service;

import com.dinhlong.pojos.Gearbox;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface GearboxService {
    List<Gearbox> getGearboxs();
    Gearbox getGearboxById(int id);
}
