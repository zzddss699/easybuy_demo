package com.zds.easybuy_demo.mapper;

import com.zds.easybuy_demo.baseDao.IBaseDao;
import com.zds.easybuy_demo.entity.User;

public interface UserMapper extends IBaseDao<User> {

    User login(String loginName,String password);

    User getUserByName(String loginName);

    User selectByPhone(String phone);

}
