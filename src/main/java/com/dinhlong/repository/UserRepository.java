/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dinhlong.repository;

import com.dinhlong.pojos.User;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface UserRepository {
    boolean addUser(User user);
    List<User> getUsers(String username);
    User getUserByUsername(String username);
    boolean updateUser(User user);
    List<User> getUsers();
    boolean deleteUser(User user);
}
