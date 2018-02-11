package com.ouyang.project.redis.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by ouyang on 2018/1/23.
 */
public class JedisUtil {
    private static JedisPool pool = new JedisPool(new JedisPoolConfig(), "localhost");

    public static Jedis getJedis() {
        return pool.getResource();
    }
}
