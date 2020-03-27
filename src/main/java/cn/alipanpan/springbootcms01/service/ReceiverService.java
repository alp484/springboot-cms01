package cn.alipanpan.springbootcms01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author yyb
 * @time 2019/8/13
 */
@Service
public class ReceiverService {

    @Autowired
    public RedisTemplate<Object, Object> redisTemplate;

    public Object getMessage(String key) {
        Object value = redisTemplate.opsForList().rightPop(key);
        return value;
    }
}

