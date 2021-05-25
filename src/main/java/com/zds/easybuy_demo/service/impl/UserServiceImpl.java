package com.zds.easybuy_demo.service.impl;

import com.zds.easybuy_demo.entity.User;
import com.zds.easybuy_demo.mapper.UserMapper;
import com.zds.easybuy_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author 157
 * @Date 2021/4/28 17:08
 * @Version 1.0
 **/
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    User user = new User();

    @Override
    public User login(String loginName, String password) {
        return user=userMapper.login(loginName,password);
    }

    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }

    @Override
    public User getUserByName(String loginName) {
        return userMapper.getUserByName(loginName);
    }

    @Override
    public User selectByPrimaryKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public User getLoginUser() {
        return user;
    }

    @Override
    public User selectByPhone(String phone) {
        return userMapper.selectByPhone(phone);
    }
}
