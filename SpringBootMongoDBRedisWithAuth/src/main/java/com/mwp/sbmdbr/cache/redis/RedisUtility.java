package com.mwp.sbmdbr.cache.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class RedisUtility {

    @Qualifier("redisClusterTemplate")
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * Obtain data from the cache.
     * @param key
     * @return value
     */
    public Object get(String key){
        return Objects.isNull(key) ? null:redisTemplate.opsForValue().get(key);
    }

    /**
     * Write data to the cache.
     * @param key
     * @param value
     * @return true (successful) false (failed)
     */
    public boolean set(String key,Object value) {
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
