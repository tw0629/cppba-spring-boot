package com.cppba.service.impl;

import com.cppba.base.bean.Result;
import com.cppba.base.util.MD5Utils;
import com.cppba.base.util.Results;
import com.cppba.entity.User;
import com.cppba.repository.UserRepository;
import com.cppba.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * 开发者
 * nickName:大黄蜂
 * email:245655812@qq.com
 * github:https://github.com/bigbeef
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @Override
    public Result login(String UserName, String password) throws Exception {
        User user = userRepository.getByUserName(UserName);
        if (user == null) {
            return Results.failure("用户不存在！");
        }
        String Md5Password= MD5Utils.encode32Md5(password);
        if (!StringUtils.equals(user.getPassword(), Md5Password)) {
            return Results.failure("密码不正确！");
        }
        return Results.success("登录成功！");
    }
}