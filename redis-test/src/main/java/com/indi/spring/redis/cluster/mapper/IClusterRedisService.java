package com.indi.spring.redis.cluster.mapper;

import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.core.types.Expiration;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IClusterRedisService {
    public boolean set(String key, String value, RedisStringCommands.SetOption nxxx, final Expiration expx);
}
