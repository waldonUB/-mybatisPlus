package cn.ak.gc.controller;

import cn.ak.gc.domain.entities.UserInfo;
import cn.ak.gc.domain.vo.ReturnModel;
import cn.ak.gc.service.LoginService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.UUID;

@RestController
public class LoginController {
    @Autowired
    LoginService loginService;

    /**
     * 登陆验证
     * @param userInfo include:1.user_name 用户名 2.password 密码
     * @return 登录用户个人信息
     */
    @RequestMapping("/loginValidate")
    public ReturnModel loginValidate(@RequestBody UserInfo userInfo, HttpSession session) {
        ReturnModel model = new ReturnModel();
        String userName = userInfo.getUserName();
        String password = userInfo.getPassword();
        if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)) {
            model.setSuccess(false);
            model.setMessage("用户名或密码为空");
            return model;
        }
        try {
            userInfo = loginService.getUserInfo(userInfo);
            if (userInfo != null) {
                Jedis jedis = new Jedis();
                String headImg = jedis.get("headImg" + userInfo.getUserId());
                userInfo.setHeadImg(headImg);
                session.setAttribute("sessionKey", userInfo);
                loginService.deleteLoginUser(userInfo);
                loginService.addLoginUser(userInfo);
                model.setSuccess(true);
                model.setData(userInfo);
            } else {
                model.setSuccess(false);
                model.setMessage("不存在此用户");
            }
        } catch (Exception e) {
            model.setSuccess(false);
            model.setMessage(e.getMessage());
        }
        return model;
    }

    /**
     * 注册新用户
     * @param userInfo include:user_name
     * @return 是否注册成功的状态
     */
    @RequestMapping("/register")
    public ReturnModel registerUser(@RequestBody UserInfo userInfo) {
        ReturnModel model = new ReturnModel();
        try {
            UserInfo oldUser = loginService.getUserInfo(userInfo);
            if (oldUser == null) {
                model.setSuccess(true);
                userInfo.setUserId(UUID.randomUUID().toString());
                loginService.addUser(userInfo);
            } else {
                model.setSuccess(false);
                model.setMessage("该用户已存在");
            }
        } catch (Exception e) {
            model.setMessage("注册信息错误：" + e);
            model.setSuccess(false);
            return model;
        }
        return model;
    }

    /**
     * 注销登陆
     * @param userInfo include:user_name 用户名
     * @return 是否注销成功的状态
     */
    @RequestMapping("/loginOut")
    public ReturnModel loginOut(@RequestBody UserInfo userInfo, HttpSession session) throws RuntimeException, SQLException {
        ReturnModel model = new ReturnModel();
        UserInfo sessionInfo = (UserInfo) session.getAttribute("sessionKey");
        if (sessionInfo != null) {
            loginService.deleteLoginUser(sessionInfo);
//            session.invalidate();//可以触发Session的监听事件
            session.removeAttribute("sessionKey");
            model.setSuccess(true);
            model.setMessage("注销成功");
            return model;
        } else {
            model.setSuccess(false);
            model.setMessage("注销失败");
            return model;
        }
    }

    /**
     * 修改密码
     * @param userInfo include:1.userName 用户名 2.password 密码
     * @return 修改密码是否成功的状态
     */
    @RequestMapping("/modifyPassword")
    public ReturnModel modifyPassword(@RequestBody UserInfo userInfo) {
        ReturnModel model = new ReturnModel();
        UserInfo userInfo1 = new UserInfo();
        userInfo1.setUserName(userInfo.getUserName());
        try {
            UserInfo oldUser = loginService.getUserInfo(userInfo1);
            if (oldUser != null) {
                model.setSuccess(true);
                oldUser.setPassword(userInfo.getPassword());
                loginService.updateUser(oldUser);
            }
        } catch (Exception e) {
            model.setMessage("修改密码错误：" + e);
            model.setSuccess(false);
            return model;
        }
        return model;
    }

    /**
     * 上传头像
     * @param userInfo include:1.imgUrl 前端传回来的图片base64码 2.userId 当前登录的用户
     * @return 修改是否成功的状态
     */
    @RequestMapping("/modifyHeadImg")
    public ReturnModel modifyHeadImg(@RequestBody UserInfo userInfo) {
        ReturnModel model = new ReturnModel();
        Jedis jedis = new Jedis();
        try {
            jedis.set("headImg_" + userInfo.getUserId(), userInfo.getHeadImg());
        } catch (Exception e) {
            model.setSuccess(false);
            model.setMessage("修改失败" + e.getMessage());
        }
        model.setSuccess(true);
        return model;
    }

    /**
     * 前端定时任务，查session信息
     * @param userInfo include:1.userId 用户主键
     * @return 用户是否在线的状态
     */
    @RequestMapping("/querySession")
    public ReturnModel querySession(@RequestBody UserInfo userInfo, HttpSession session) {
        ReturnModel model = new ReturnModel();
        model.setSuccess(true);
        return model;
    }
}
