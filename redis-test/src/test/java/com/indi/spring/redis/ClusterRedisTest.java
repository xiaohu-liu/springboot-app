package com.indi.spring.redis;


import com.indi.spring.redis.cluster.mapper.impl.ClusterRedisServiceImpl;
import com.indi.spring.redis.mapper.impl.RedisServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.core.types.Expiration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
@WebAppConfiguration
public class ClusterRedisTest {

    @Autowired
    private ClusterRedisServiceImpl redisService;


    @Test
    public void test1() {
        redisService.set("nickname2", "xiaohu-liu", RedisStringCommands.SetOption.SET_IF_ABSENT, Expiration.seconds(10l));
    }


}
