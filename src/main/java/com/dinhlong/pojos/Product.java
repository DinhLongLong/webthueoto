/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dinhlong.pojos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.context.annotation.Description;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "product")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String name;
    
    private String price;
    
    private String img;
    
    private String description;
    
    @Column(name = "license_plate")
    private String licensePlate;
    
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
    
    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;
    
    @ManyToOne
    @JoinColumn(name = "gearbox_id", nullable = false)
    private Gearbox gearbox;
    
    @ManyToOne
    @JoinColumn(name = "fuel_id", nullable = false)
    private Fuel fuel;
    
    @ManyToOne
    @JoinColumn(name = "color_id", nullable = false)
    private Color color;
    
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
    private Set<Comment> comments;
    
    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
    private Set<Love> loves;
    
    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
    private Set<ProductOrder> productOrders;

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
     * @return the price
     */
    public String getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the licensePlate
     */
    public String getLicensePlate() {
        return licensePlate;
    }

    /**
     * @param licensePlate the licensePlate to set
     */
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    /**
     * @return the gearbox
     */
    public Gearbox getGearbox() {
        return gearbox;
    }

    /**
     * @param gearbox the gearbox to set
     */
    public void setGearbox(Gearbox gearbox) {
        this.gearbox = gearbox;
    }

    /**
     * @return the fuel
     */
    public Fuel getFuel() {
        return fuel;
    }

    /**
     * @param fuel the fuel to set
     */
    public void setFuel(Fuel fuel) {
        this.fuel = fuel;
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * @return the img
     */
    public String getImg() {
        return img;
    }

    /**
     * @param img the img to set
     */
    public void setImg(String img) {
        this.img = img;
    }

    /**
     * @return the brand
     */
    public Brand getBrand() {
        return brand;
    }

    /**
     * @param brand the brand to set
     */
    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    /**
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * @return the category
     */
    public Category getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(Category category) {
        this.category = category;
    }
}
