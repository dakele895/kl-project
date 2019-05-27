package com.kl.klshop.dao.impl;

import com.kl.klshop.dao.RedisDao;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.JedisCluster;

import javax.annotation.Resource;

/**
 * @Auther: dalele
 * @Date: 2019/4/20 19:45
 * @Description:
 */
@Repository("redisDAO")
public class RedisDaoImpl implements RedisDao {
    @Resource
    private JedisCluster jedisCluster;

    @Override
    public void set(String key, String value) {
        jedisCluster.set(key, value);
    }

    @Override
    public String get(String key) {
        return jedisCluster.get(key);
    }

    @Override
    public void delete(String key) {
        jedisCluster.del(key);
    }
}
