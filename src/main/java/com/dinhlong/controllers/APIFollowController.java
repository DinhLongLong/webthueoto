/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dinhlong.controllers;

import com.dinhlong.pojos.Follow;
import com.dinhlong.pojos.User;
import com.dinhlong.service.FollowService;
import com.dinhlong.service.UserService;
import java.util.List;
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
public class APIFollowController {
    
    @Autowired
    private FollowService followService;
    
    @Autowired
    private UserService userService;
    
//    ADD LOVE
    @PostMapping(path = "/api/user/add-follow", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Follow> addFollow(@RequestBody Map<String, String> params) {
        String username = params.get("username");
        String followerName = params.get("followerName");
        
        Follow follow = new Follow();
        
        User user = this.userService.getUserByUsername(username);
        follow.setUser(user);
        
        User follower = this.userService.getUserByUsername(followerName);
        follow.setFollower(follower);
        
        Boolean isSuccess = this.followService.addFollow(follow);
        
        if (isSuccess) {
            return new ResponseEntity<>(follow, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    
//    DELETE LOVE
    @PostMapping(path = "/api/user/delete-follow", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Object> deleteFollow(@RequestBody Map<String, String> params) {
        String username = params.get("username");
        String followerName = params.get("followerName");
        
        List<Follow> follows = this.followService.getFollowsByFollowerId(userService.getUserByUsername(followerName).getId());

        for (Follow follow : follows) {
            if (follow.getUser().getUsername().equals(username)) {
                return new ResponseEntity<>(followService.deleteFollow(follow.getId()), HttpStatus.OK);
            };
        };
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    };
}
