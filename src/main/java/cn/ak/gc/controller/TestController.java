package cn.ak.gc.controller;

import cn.ak.gc.commen.model.Page;
import cn.ak.gc.commen.utils.TestUtils;
import cn.ak.gc.domain.entities.UserInfo;
import cn.ak.gc.service.LoginService;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@Api("testController相关的API")
@RestController
public class TestController {
    private final Logger logger = LogManager.getLogger();

    public TestController() {
        System.out.println("spring会对扫描到的包进行实例化");
    }
    @Autowired
    LoginService loginService;
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


    @RequestMapping("/deleteUser")
    public void deleteUser() {
        loginService.deleteUser();
    }

    @RequestMapping("/getEntities")
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    // DEFAULT是使用默认的隔离级别,mysql默认的隔离级别是repeatable-read,可以解决到不可重复读的级别
    public List<UserInfo> getEntities() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId("2a602121");
//        userInfo.setUserName("waldon" + System.currentTimeMillis());
        userInfo.setUserName("waldon1552374397476");
        logger.error("测试错误");
        logger.warn("测试警告");
        logger.info("测试信息");
        logger.debug("测试debug");
        loginService.updateUser(userInfo);
        loginService.deleteLoginUser(userInfo);
        List<UserInfo> test = loginService.getEntities(userInfo);
        for(UserInfo u : test) {
            System.out.println(u);
        }
        return test;
    }

    @RequestMapping("/getPageEntities")
    public Page<UserInfo> getPageEntities() throws Exception {
        UserInfo userInfo = TestUtils.test();
        return loginService.getPageEntities(userInfo, 1 , 5);
    }

    @RequestMapping("/getFTPFile")
    public void getFTPFile() {

    }

}
