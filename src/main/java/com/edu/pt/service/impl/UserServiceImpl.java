package com.edu.pt.service.impl;

import com.edu.pt.entity.user.TechLevel;
import com.edu.pt.entity.user.User;
import com.edu.pt.mapper.UserMapper;
import com.edu.pt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    public List<User> findUserByClassId(int class_id) {
        return userMapper.findUserByClassId(class_id);
    }

    @Override
    public List<User> findAllUser(int role_id) {
        return userMapper.findAllUser(role_id);
    }

    public User findUserByUid(int uid) {
        return userMapper.findUserByUid(uid);
    }

    public void addUser(User user){
        userMapper.addUser(user);
    }

    public User updateUser(User user) {
      userMapper.updateUser(user);
      return userMapper.findByUsername(user.getUsername());
    }

    public User altUserStatus(int uid) {
       userMapper.altUserStatus(uid);
       return userMapper.findByUid(uid);
    }

    public List<TechLevel> getAllLevels() {
        return userMapper.getLevels();
    }

}
