package com.edu.pt.service;
import com.edu.pt.entity.user.TechLevel;
import com.edu.pt.entity.user.User;
import org.springframework.dao.DuplicateKeyException;

import java.util.List;

public interface UserService {

    public User findByUsername(String username);



    public List<User> findUserByClassId(int class_id);
    public List<User> findAllUser(int role_id);

    public User findUserByUid(int uid);

    public void addUser(User user) throws DuplicateKeyException;

    public User updateUser(User user);

    public User altUserStatus(int uid);

    public List<TechLevel> getAllLevels();


}
