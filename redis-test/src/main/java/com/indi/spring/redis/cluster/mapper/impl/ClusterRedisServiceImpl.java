package com.indi.spring.redis.cluster.mapper.impl;

import com.indi.spring.redis.cluster.mapper.IClusterRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.types.Expiration;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;


@Service
public class ClusterRedisServiceImpl implements IClusterRedisService {

    @Autowired
    private RedisTemplate<String, ?> redisTemplate;


    @Override
    public boolean set(final String key, final String value, final RedisStringCommands.SetOption nxxx, final Expiration expx) {
        RedisSerializer<String> serializer = redisTemplate.getStringSerializer();

        /**
         * Converts a given {@link Expiration} to the according {@code SET} command argument.<br />
         * <dl>
         * <dt>{@link TimeUnit#SECONDS}</dt>
         * <dd>{@code EX}</dd>
         * <dt>{@link TimeUnit#MILLISECONDS}</dt>
         * <dd>{@code PX}</dd>
         * </dl>
         *
         * @param expiration
         * @return
         * @since 1.7
         */

        /**
         * Converts a given {@link RedisStringCommands.SetOption} to the according {@code SET} command argument.<br />
         * <dl>
         * <dt>{@link RedisStringCommands.SetOption#UPSERT}</dt>
         * <dd>{@code byte[0]}</dd>
         * <dt>{@link RedisStringCommands.SetOption#SET_IF_ABSENT}</dt>
         * <dd>{@code NX}</dd>
         * <dt>{@link RedisStringCommands.SetOption#SET_IF_PRESENT}</dt>
         * <dd>{@code XX}</dd>
         * </dl>
         *
         * @param option
         * @return
         * @since 1.7
         */
        redisTemplate.getConnectionFactory().getConnection()
                .set(serializer.serialize(key), serializer.serialize(value), expx, nxxx);
        return true;
    }

}
