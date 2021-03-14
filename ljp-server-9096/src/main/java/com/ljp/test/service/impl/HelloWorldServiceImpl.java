package com.ljp.test.service.impl;

import com.google.common.collect.Lists;
import com.ljp.test.service.HelloWorldService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;

/**
 * @author 罗俊平
 * @email 591402399@qq.com
 * @date 2021/2/18
 * @since 1.0.0
 **/
@Slf4j
@Service
public class HelloWorldServiceImpl implements HelloWorldService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Transactional(rollbackFor = Throwable.class)
    @Override
    public String lockByRedis(String redisValue) {
        Boolean lockByRedis = stringRedisTemplate.opsForValue().setIfAbsent("lockByRedis", redisValue, Duration.ofSeconds(600));
        if (lockByRedis) {
            return "locked success!!!";
        }
        Long result = stringRedisTemplate.execute(RedisScript.of("local result =  999; local key = KEYS[1]; local value = ARGV[1]; if redis.call('get', key) == value then result = redis.call('del', key) end; return result;", Long.class), Lists.newArrayList("lockByRedis"), "cd152a7dfd324098af58f01807e9f170");
        System.out.println("execute = " + result);
        return "locked fail!!!";
    }

}
