/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dinhlong.pojos;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Admin
 */
@Entity
@Table(name="user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String username;

    private String password;
    
    @Transient
    private String confirmPassword;
    
    private String name;
    
    private String phone;
    
    private String email;
    
    private String address;
    
    @Column(name = "user_role")
    private String userRole;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<Product> products;
    
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<Comment> comments;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<Love> loves;
    
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<Follow> follows;
    
    @OneToMany(mappedBy = "follower", fetch = FetchType.EAGER)
    private Set<Follow> follows1;
    
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<ProductOrder> productOrders;
    
    @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER)
    private Set<ProductOrder> productOrders1;
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the confirmPassword
     */
    public String getConfirmPassword() {
        return confirmPassword;
    }

    /**
     * @param confirmPassword the confirmPassword to set
     */
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the userRole
     */
    public String getUserRole() {
        return userRole;
    }

    /**
     * @param userRole the userRole to set
     */
    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}