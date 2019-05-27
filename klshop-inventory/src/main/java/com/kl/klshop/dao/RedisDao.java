package com.kl.klshop.dao;

/**
 * @Auther: dalele
 * @Date: 2019/4/20 19:45
 * @Description:
 */
public interface RedisDao {
    void set(String key, String value);
    String get(String key);
    void delete(String key);
}
