/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dinhlong.service.impl;

import com.dinhlong.pojos.Follow;
import com.dinhlong.repository.FollowRepository;
import com.dinhlong.service.FollowService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class FollowServiceImpl implements FollowService {

    @Autowired
    private FollowRepository followRepository;
    
    @Override
    public boolean addFollow(Follow follow) {
        return this.followRepository.addFollow(follow);
    }

    @Override
    public boolean deleteFollow(int id) {
        return this.followRepository.deleteFollow(id);
    }

    @Override
    public Follow getFollowById(int id) {
        return this.followRepository.getFollowById(id);
    }

    @Override
    public List<Follow> getFollowsByFollowerId(int followerId) {
        return this.followRepository.getFollowsByFollowerId(followerId);
    }

    @Override
    public List<Follow> getFollowsByUserId(int userId) {
        return this.followRepository.getFollowsByUserId(userId);
    }
    
}
