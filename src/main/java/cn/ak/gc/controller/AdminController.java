package cn.ak.gc.controller;

import cn.ak.gc.domain.entities.UserInfo;
import cn.ak.gc.domain.vo.ReturnModel;
import cn.ak.gc.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/gc/admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @RequestMapping(value = "deleteUser", method = RequestMethod.DELETE)
    public ReturnModel deleteUser(@RequestParam("userId") String userId) {
        ReturnModel model = new ReturnModel();
        model.setSuccess(true);
        adminService.deleteUser(userId);
        return model;
    }

    @RequestMapping(value = "getUserList", method = RequestMethod.POST)
    public ReturnModel getUserList() {
        ReturnModel model = new ReturnModel();
        List<UserInfo> list = adminService.getUserList();
        model.setSuccess(true);
        model.setData(list);
        return model;
    }
}
