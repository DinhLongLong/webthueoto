/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dinhlong.controllers;

import com.dinhlong.pojos.Product;
import com.dinhlong.pojos.ProductOrder;
import com.dinhlong.pojos.User;
import com.dinhlong.service.ProductOrderService;
import com.dinhlong.service.ProductService;
import com.dinhlong.service.UserService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Admin
 */
@RestController
public class APIAdminController {
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private ProductService productService;
    
    @Autowired
    private ProductOrderService productOrderService;
    
    @Autowired
    private MailSender mailSender;
    
    @PostMapping(path = "/api/admin/delete-user", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<User> deleteUser(@RequestBody Map<String, String> params) {
        String username = params.get("username");
        
        User user = this.userService.getUserByUsername(username);
        
        Boolean isSuccess = this.userService.deleteUser(user);
        
        if (isSuccess) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    
    @PostMapping(path = "/api/admin/delete-product", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Product> deleteProduct(@RequestBody Map<String, String> params) {
        int productId = Integer.parseInt(params.get("productId"));
        
        Product product = this.productService.getProductById(productId);
        
        Boolean isSuccess = this.productService.deleteProduct(product);
        
        if (isSuccess) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    
    @PostMapping(path = "/api/admin/check-product-order", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<ProductOrder> checkProductOrder(@RequestBody Map<String, String> params) {
        int productOrderId = Integer.parseInt(params.get("productOrderId"));
        
        ProductOrder productOrder = this.productOrderService.getProductOrderById(productOrderId);
        productOrder.setConfirmStatus("checked");
        
        Boolean isSuccess = this.productOrderService.updateProductOrder(productOrder);
        
        if (isSuccess) {
            sendMail("dinhlongdragon@gmail.com", this.productOrderService.getProductOrderById(productOrderId).getUser().getEmail(), "Thông tin yêu cầu thuê xe của bạn", "Dưới đây là thông tin bên cho thuê, người thuê tự liên hệ!"
                            + "\nNgười cho thuê: " + this.productOrderService.getProductOrderById(productOrderId).getOwner().getUsername()
                            + "\nTên cá nhân/doanh nghiệp: " + this.productOrderService.getProductOrderById(productOrderId).getOwner().getName()
                            + "\nEmail: " + this.productOrderService.getProductOrderById(productOrderId).getOwner().getEmail()
                            + "\nSố điện thoại: " + this.productOrderService.getProductOrderById(productOrderId).getOwner().getPhone()
                            + "\nĐịa chỉ: " + this.productOrderService.getProductOrderById(productOrderId).getOwner().getAddress()
                            + "\nXe bạn muốn thuê: " + this.productOrderService.getProductOrderById(productOrderId).getProduct().getName()
                            + "\nGiá thuê/ngày: " + this.productOrderService.getProductOrderById(productOrderId).getProduct().getPrice()
                            + "\nThời gian bạn muốn thuê: " + this.productOrderService.getProductOrderById(productOrderId).getTimeDay()
            );
            sendMail("dinhlongdragon@gmail.com", this.productOrderService.getProductOrderById(productOrderId).getOwner().getEmail(), "Yêu cầu thuê xe", "Dưới đây là thông tin yêu cầu thuê xe!"
                            + "\nKhách hàng yêu cầu: " + this.productOrderService.getProductOrderById(productOrderId).getUser().getUsername()
                            + "\nTên cá nhân/doanh nghiệp: " + this.productOrderService.getProductOrderById(productOrderId).getUser().getName()
                            + "\nEmail: " + this.productOrderService.getProductOrderById(productOrderId).getUser().getEmail()
                            + "\nSố điện thoại: " + this.productOrderService.getProductOrderById(productOrderId).getUser().getPhone()
                            + "\nĐịa chỉ: " + this.productOrderService.getProductOrderById(productOrderId).getUser().getAddress()
                            + "\nXe muốn thuê: " + this.productOrderService.getProductOrderById(productOrderId).getProduct().getName()
                            + "\nGiá thuê/ngày: " + this.productOrderService.getProductOrderById(productOrderId).getProduct().getPrice()
                            + "\nThời gian muốn thuê: " + this.productOrderService.getProductOrderById(productOrderId).getTimeDay()
                            + "\nYêu cầu bổ sung từ khách hàng: " + this.productOrderService.getProductOrderById(productOrderId).getNote()
            );
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    
    @PostMapping(path = "/api/admin/delete-product-order", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<ProductOrder> deleteProductOrder(@RequestBody Map<String, String> params) {
        int productOrderId = Integer.parseInt(params.get("productOrderId"));
        
        ProductOrder productOrder = this.productOrderService.getProductOrderById(productOrderId);
        Boolean isSuccess = this.productOrderService.deleteProductOrder(productOrder);
        
        if (isSuccess) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    
    public void sendMail(String from, String to, String subject, String content){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(from);
        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        mailMessage.setText(content);
        
        mailSender.send(mailMessage);
    }
}
