package com.zds.easybuy_demo.service;

import com.zds.easybuy_demo.entity.UserAddress;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserAddressService {

    /*
     * @Author 157
     * @Description //根据loginName的userId 查询用户地址
     * @MethodName queryUserAddressList
     * @Date 12:00 2021/5/14
     * @Param [id]
     * @return java.util.List<com.zds.easybuy_demo.entity.UserAddress>
     **/
    List<UserAddress> queryUserAddressList(@Param(value = "id") Integer id);

    int insert(UserAddress userAddress);

    UserAddress selectByPrimaryKey(Integer id);
}
