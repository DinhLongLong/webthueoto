/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dinhlong.controllers;

import com.dinhlong.pojos.User;
import com.dinhlong.service.UserService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Admin
 */
@RestController
public class APIUserController {
    
    @Autowired
    private UserService userService;
    
    @PostMapping(path = "/api/user/update-user", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<User> updateUser(@RequestBody Map<String, String> params) {
        String username = params.get("username");
        String name = params.get("name");
        String phone = params.get("phone");
        String email = params.get("email");
        String address = params.get("address");
        
        User user = this.userService.getUserByUsername(username);
        user.setName(name);
        user.setPhone(phone);
        user.setEmail(email);
        user.setAddress(address);
        
        Boolean isSuccess = this.userService.updateUser(user);
        
        if (isSuccess) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
