package com.kl.klshop.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.kl.klshop.dao.RedisDao;
import com.kl.klshop.mapper.UserMapper;
import com.kl.klshop.model.User;
import com.kl.klshop.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Auther: dalele
 * @Date: 2019/4/18 23:35
 * @Description:
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Resource
    private RedisDao redisDao;

    @Override
    public User findUserInfo() {
        return userMapper.findUserInfo();
    }

    @Override
    public User getCachedUserInfo() {
        redisDao.set("cached_user_lisi", "{\"name\": \"lisi\", \"age\":28}");

        String userJSON = redisDao.get("cached_user_lisi");
        JSONObject userJSONObject = JSONObject.parseObject(userJSON);

        User user = new User();
        user.setName(userJSONObject.getString("name"));
        user.setAge(userJSONObject.getInteger("age"));
        return user;
    }


}
