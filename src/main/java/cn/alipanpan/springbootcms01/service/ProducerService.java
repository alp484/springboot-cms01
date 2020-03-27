package cn.alipanpan.springbootcms01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;


/**
 * @author yyb
 * @time 2019/8/13
 */

@Service
public class ProducerService {


    @Autowired
    public RedisTemplate<Object, Object> redisTemplate;

    public String sendMessage(String key, String value) {
        try {
            redisTemplate.opsForList().leftPush(key, value);
            return "send message succeed!";

        } catch (Exception e) {
            e.printStackTrace();
            return "end message fail!";
        }
    }

}