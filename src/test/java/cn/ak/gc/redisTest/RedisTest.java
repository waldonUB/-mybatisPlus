package cn.ak.gc.redisTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class RedisTest {

    /**
     * redis计数器
     * */
    @Test
    public void incrementTest() {
        Jedis jedis = new Jedis();
        jedis.incr("incrementKey");
        System.out.println(jedis.get("incrementKey"));
    }
}
