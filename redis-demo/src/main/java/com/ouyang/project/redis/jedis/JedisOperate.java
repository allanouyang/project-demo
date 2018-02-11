package com.ouyang.project.redis.jedis;

import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * Created by ouyang on 2018/1/23.
 */
public class JedisOperate {

    public void simpleOperate() {
        Jedis jedis = JedisUtil.getJedis();
        jedis.setex("foo", 20, "bar");
        String foobar = jedis.get("foo");
        System.out.println("foo.redis value is " + foobar);
        jedis.zadd("sose", 0, "car");
        jedis.zadd("sose", 0, "bike");
        Set<String> sose = jedis.zrange("sose", 0, -1);
//        sose.stream().map(s -> {
//            System.out.println(s);
//            return s;
//        }).peek(System.out::println);
        sose.forEach(System.out::println);
        jedis.close();
    }

}
