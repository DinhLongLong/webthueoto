/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dinhlong.repository;

import com.dinhlong.pojos.Color;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface ColorRepository {
    List<Color> getColors();
    Color getColorById(int id);
}
