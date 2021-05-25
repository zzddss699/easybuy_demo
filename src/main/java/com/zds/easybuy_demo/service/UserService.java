package com.zds.easybuy_demo.service;

import com.zds.easybuy_demo.entity.News;
import com.zds.easybuy_demo.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {

    User login(@Param("loginName") String loginName,@Param("password") String password);

    List<User> selectAll();

    int insert(User user);

    User getUserByName(@Param("loginName") String loginName);

    User selectByPrimaryKey(Integer id);

    User getLoginUser();

    User selectByPhone(@Param("phone") String phone);
}
