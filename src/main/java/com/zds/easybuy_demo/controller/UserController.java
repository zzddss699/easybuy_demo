package com.zds.easybuy_demo.controller;

import com.zds.easybuy_demo.baseDao.RespBean;
import com.zds.easybuy_demo.entity.User;
import com.zds.easybuy_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author 157
 * @Date 2021/4/28 17:13
 * @Version 1.0
 **/
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    User user = new User();

    @GetMapping(value = "/login")
    public RespBean login(@RequestParam String loginName, @RequestParam String password){
        String md5password = DigestUtils.md5DigestAsHex(password.getBytes());
        user = userService.login(loginName, md5password);
        if (user!=null){
            return RespBean.success("登录成功",user);
        }
        return RespBean.error("登录失败");
    }

    @GetMapping("send")
    public RespBean send(@RequestParam String phone){
        User user = userService.selectByPhone(phone);
        if (user!=null){
            //Integer send = SendMessageUtil.send("acaa", "d41d8cd98f00b204e980", phone, "验证码:" + SendMessageUtil.getRandomCode(6));
            return RespBean.success("验证码发送成功",111111);
        }
        return RespBean.error("手机号登录没有该手机用户");
    }

    @GetMapping("sendLogin")
    public RespBean sendLogin(@RequestParam String phone){
        User user = userService.selectByPhone(phone);
        if (user!=null){
            return RespBean.success("登录成功",user);
        }
        return RespBean.error("登录失败");
    }

    /*
     * @Author 157
     * @Description //注册新用户User
     * @MethodName insert
     * @Date 18:16 2021/5/10
     * @Param [user]
     * @return com.zds.easybuy_demo.baseDao.RespBean
     **/
    @PostMapping(value = "/insertUser")
    public RespBean insert(User user){
        User userByName = userService.getUserByName(user.getLoginName());
        if (userByName == null){
            user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
            userService.insert(user);
            return RespBean.success("注册成功");
        }else {
            return RespBean.error("注册失败,用户名已存在.");
        }
    }

    @GetMapping(value = "ById")
    public RespBean selectByPrimaryKey(@RequestParam Integer id){
        User user = userService.selectByPrimaryKey(id);
        return RespBean.success("根据Id查询User成功",user);
    }

    @RequestMapping(value = "zhuXiao")
    public RespBean zhuXiao(){
        user = new User();
        return RespBean.success("退出登录成功");
    }



    public User getUser() {
        return user;
    }
}
