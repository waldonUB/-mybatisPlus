package cn.ak.gc.controller;

import cn.ak.gc.commen.model.Page;
import cn.ak.gc.commen.utils.TestUtils;
import cn.ak.gc.domain.entities.UserInfo;
import cn.ak.gc.domain.repository.CommonRepository;
import cn.ak.gc.service.LoginService;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.*;
import org.apache.catalina.User;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.servlet.http.HttpSession;
import java.io.FileNotFoundException;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@Api("testController相关的API")
@RestController
public class TestController {
    private final Logger logger = LogManager.getLogger();
    private JedisPool jedisPool = new JedisPool();

    public TestController() {
        System.out.println("spring会对扫描到的包进行实例化");
    }
    @Autowired
    LoginService loginService;

    @Autowired
    CommonRepository repository;
    @ApiOperation("获取用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "userName", dataType = "String", required = true, value="用户的姓名", defaultValue="zhaojigang"),
            @ApiImplicitParam(paramType = "query", name = "password", dataType = "String", required = true, value="用户的密码", defaultValue="123456"),
    })
    @ApiResponses({
            @ApiResponse(code = 400, message="请求参数没填好"),
            @ApiResponse(code = 404, message="不存在该地址")
    })

    @RequestMapping(value = "/redisSession", method = RequestMethod.POST)
    public void redisSession(HttpSession session) {
        String name= "waldon";
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("sex", "man");
        Object obj = session.getAttribute("name");
        session.setAttribute("name", json);
    }


    @RequestMapping(value = "/deleteUser" ,method = RequestMethod.GET)
    public void deleteUser() {
        loginService.deleteUser();
    }

    @RequestMapping(value = "/getEntities" ,method = RequestMethod.GET)
    @Transactional(propagation = Propagation.REQUIRED)
    // DEFAULT是使用默认的隔离级别,mysql默认的隔离级别是repeatable-read,可以解决到不可重复读的级别
    public List<UserInfo> getEntities() throws FileNotFoundException {
        UserInfo userInfo = new UserInfo();
//        CloseableHttpClient client = HttpClients.createDefault();
        TransactionStatus transactionStatus = TransactionAspectSupport.currentTransactionStatus();
        userInfo.setUserId("2a602121897");
        userInfo.setUserName("waldon" + LocalTime.now());
        try{
            loginService.updateUser(userInfo);
            loginService.deleteLoginUser(userInfo);
        } catch (Exception e) {
            System.out.println("内部事务出错了");
        }

        List<UserInfo> test = loginService.getEntities(userInfo);
        return test;
    }

    @RequestMapping(value = "/getPageEntities", method = RequestMethod.GET)
    public Page<UserInfo> getPageEntities() throws Exception {
        UserInfo userInfo = TestUtils.test();
        return loginService.getPageEntities(userInfo, 1 , 5);
    }

    @RequestMapping(value = "/getFTPFile", method = RequestMethod.POST)
    public void getFTPFile() {

    }

    @RequestMapping(value = "/redisIncreTest", method = RequestMethod.GET)
    public String redisIncreTest() {
        Jedis jedis = null;
        if (jedisPool != null) {
            jedis = jedisPool.getResource();
        } else {
            jedisPool = new JedisPool();
        }
        long increNum = jedis.incr("redisIncreTest");
        return "当前增量：" + increNum;
    }

    /**
     * 测试
     * */
    @RequestMapping(value = "/entityParam", method = RequestMethod.GET)
    public String entityParam() {
        UserInfo userInfo = new UserInfo();
        String jsonObject = JSONObject.toJSONString(userInfo);
        userInfo.setUserId("2a602121897");
        repository.updateTest(userInfo);
        return "666";
    }

}
