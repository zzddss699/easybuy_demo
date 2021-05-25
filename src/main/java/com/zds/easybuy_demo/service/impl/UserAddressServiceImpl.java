package com.zds.easybuy_demo.service.impl;

import com.zds.easybuy_demo.entity.UserAddress;
import com.zds.easybuy_demo.mapper.UserAddressMapper;
import com.zds.easybuy_demo.service.UserAddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @ClassName UserAddressServiceImpl
 * @Description TODO
 * @Author 157
 * @Date 2021/5/14 11:55
 * @Version 1.0
 **/
@Service
public class UserAddressServiceImpl implements UserAddressService {

    @Resource
    private UserAddressMapper userAddressMapper;

    /*
     * @Author 157
     * @Description //查询用户地址列表
     * @MethodName queryUserAddressList
     * @Date 12:13 2021/5/14
     * @Param [id]
     * @return java.util.List<com.zds.easybuy_demo.entity.UserAddress>
     **/
    @Override
    public List<UserAddress> queryUserAddressList(Integer id) {
        return userAddressMapper.queryUserAddressList(id);
    }

    /*
     * @Author 157
     * @Description //添加用户地址
     * @MethodName insert
     * @Date 12:06 2021/5/14
     * @Param [userAddress]
     * @return int
     **/
    @Override
    public int insert(UserAddress userAddress) {
        userAddress.setCreateTime(new Date());
        userAddress.setIsDefault(0);
        return userAddressMapper.insert(userAddress);
    }

    @Override
    public UserAddress selectByPrimaryKey(Integer id) {
        return userAddressMapper.selectByPrimaryKey(id);
    }
}
