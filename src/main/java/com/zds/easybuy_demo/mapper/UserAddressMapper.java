package com.zds.easybuy_demo.mapper;

import com.zds.easybuy_demo.baseDao.IBaseDao;
import com.zds.easybuy_demo.entity.UserAddress;

import java.util.List;

public interface UserAddressMapper extends IBaseDao<UserAddress> {

    List<UserAddress> queryUserAddressList(Integer id);

}
