/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dinhlong.service.impl;

import com.dinhlong.pojos.User;
import com.dinhlong.repository.UserRepository;
import com.dinhlong.service.UserService;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service("userDetailsService")
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
    @Override
    public boolean addUser(User user) {
        String password = user.getPassword();
        user.setPassword(passwordEncoder.encode(password));
        user.setUserRole("ROLE_USER");
        
        return this.userRepository.addUser(user);
    }

    @Override
    public List<User> getUsers(String username) {
        
        return this.userRepository.getUsers(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User u = this.userRepository.getUserByUsername(username);
        if (u == null) {
            throw new UsernameNotFoundException("Invalid");
        }
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(u.getUserRole()));
        
        return new org.springframework.security.core.userdetails.User(
                u.getUsername(), u.getPassword(), authorities);
    }

    @Override
    public User getUserByUsername(String username) {
        return this.userRepository.getUserByUsername(username);
    }

    @Override
    public boolean updateUser(User user) {
        return this.userRepository.updateUser(user);
    }

    @Override
    public List<User> getUsers() {
        return this.userRepository.getUsers();
    }

    @Override
    public boolean deleteUser(User user) {
        return this.userRepository.deleteUser(user);
    }
    
}
