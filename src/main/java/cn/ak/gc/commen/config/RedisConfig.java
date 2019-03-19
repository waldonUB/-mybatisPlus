package cn.ak.gc.commen.config;

import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisConfig {
    public JedisPool jedisPool;
    public Jedis jedis; //TODO 有待改进
    @Autowired
    public void setJedisPool(JedisPool jedisPool) {
        jedis = jedisPool.getResource();
    }
}
