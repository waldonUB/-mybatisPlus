package cn.ak.gc.controller;

import cn.ak.gc.domain.entities.UserInfo;
import cn.ak.gc.domain.vo.ReturnModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class LoginController {
    @Autowired
    RedisTemplate redisTemplate;

    @RequestMapping("/login_validate")
    public ReturnModel loginValidate(@RequestBody UserInfo userInfo, HttpServletRequest request) {
        ReturnModel model = new ReturnModel();
        String userName = userInfo.getUserName();
        String password = userInfo.getPassword();
        if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)) {
            model.setSuccess(false);
            return model;
        }
        return null;
    }
}
