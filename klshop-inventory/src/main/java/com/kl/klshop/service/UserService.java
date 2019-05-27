package com.kl.klshop.service;

import com.kl.klshop.model.User;

/**
 * @Auther: dalele
 * @Date: 2019/4/18 23:28
 * @Description:
 */
public interface UserService {
    /**
     * 查询用户信息
     * @return 用户信息
     */
     User findUserInfo();

    /**
     * 查询redis中缓存的用户信息
     * @return
     */
     User getCachedUserInfo();
}
