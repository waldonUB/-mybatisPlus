package cn.ak.gc;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest extends GcApplicationTests{
    @Test
    public void listMapTest() {
        Jedis jedis = new Jedis();
        Map<String, Object> map = new HashMap<>();
        map.put("test1", UUID.randomUUID().toString());
        map.put("test2", UUID.randomUUID().toString());
        jedis.lpush("listMap", JSON.toJSONString(map));
    }

    @Test
    public void getListMap() {
        Jedis jedis = new Jedis();
        List<String> listMap = jedis.lrange("listMap", 0, -1); // 从0到-1获取全部元素
//        JSONArray list = JSON.parseArray(listMap);
    }

}
