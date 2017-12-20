package com.indi.spring.redis.mapper;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRedisService {
    public boolean set(String key, String value);

    public boolean set(String key, String value, String nxxx,
                       String expx, long time);

    public String get(String key);

    public boolean expire(String key, long expire);

    public <T> boolean setList(String key, List<T> list);

    public <T> List<T> getList(String key, Class<T> clz);

    public long lpush(String key, Object obj);

    public long rpush(String key, Object obj);

    public String lpop(String key);
}
