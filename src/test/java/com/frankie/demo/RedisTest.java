package com.frankie.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author: Yao Frankie
 * @date: 2020/1/28 21:18
 */
@SpringBootTest
public class RedisTest {

    @Autowired
    JedisPool redisPoolFactory;


//    Reference: https://www.cnblogs.com/rwxwsblog/p/5846752.html
    @Test
    public void jedisSimpleTest(){
        Jedis jedis = new Jedis("localhost", 6379);
//      1. String
        jedis.set("name", "yyc");
//      2. Hash
        jedis.hset("user:1", "name", "frankie");
        jedis.hset("user:1", "age", "25");
//      3. List
        jedis.rpush("list:1", "1", "2", "3");
//      4. Set
        jedis.sadd("set:1", "running", "reading", "coding");
//      5. Sorted Set
        jedis.zadd("sorted_set:1", 120, "iPhone11");
        jedis.zadd("sorted_set:1", 100, "iPhone_XR_MAX");

        jedis.close();
    }

    @Test
    public void playJedisByPoolTest(){

        try (Jedis jedis = redisPoolFactory.getResource()){
            jedis.set("age", "25");
        }
    }
}
