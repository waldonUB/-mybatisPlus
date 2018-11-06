package cn.ak.gc.controller;

import cn.ak.gc.commen.model.Page;
import cn.ak.gc.domain.entities.UserInfo;
import cn.ak.gc.service.LoginService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@RestController
public class TestController {
    @Autowired
    LoginService loginService;

    @RequestMapping("/redisSession")
    public void redisSession(HttpSession session) {
        String name= "waldon";
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("sex", "man");
        Object obj = session.getAttribute("name");
        session.setAttribute("name", json);
    }

    @RequestMapping("/saveUser")
    public void saveUser() {
        loginService.saveUser();
    }

    @RequestMapping("/updateUser")
    public void updateUser() {
        loginService.updateUser();
    }

    @RequestMapping("/deleteUser")
    public void deleteUser() {
        loginService.deleteUser();
    }

    @RequestMapping("/getEntities")
    public List<UserInfo> getEntities() {
        UserInfo userInfo = new UserInfo();
        return loginService.getEntities(userInfo);
    }

    @RequestMapping("/getPageEntities")
    public Page<UserInfo> getPageEntities() {
        UserInfo userInfo = new UserInfo();
        return loginService.getPageEntities(userInfo, 1 , 5);
    }

}
