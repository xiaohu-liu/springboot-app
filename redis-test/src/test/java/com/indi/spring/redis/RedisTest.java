package com.indi.spring.redis;


import com.indi.spring.redis.mapper.impl.RedisServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
@WebAppConfiguration
public class RedisTest {

    @Autowired
    private RedisServiceImpl redisService;


    @Test
    public void test1() {
        redisService.set("name", "xiaohu-liu");
        redisService.set("nickname2", "xiaohu-liu", "NX", "EX", 10);
    }


}
