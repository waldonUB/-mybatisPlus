package cn.ak.gc.service.impl;

import cn.ak.gc.commen.utils.CommonDAO;
import cn.ak.gc.domain.entities.UserInfo;
import cn.ak.gc.service.AdminService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    CommonDAO<UserInfo> commonDAO;

    @Override
    public void deleteUser(String userId) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(userId);
        commonDAO.deleteVO(userInfo);
    }

    @Override
    public List<UserInfo> getUserList() {
        UserInfo userInfo = new UserInfo();
        JSONObject jsonObject = new JSONObject();
        return commonDAO.getEntities(userInfo, jsonObject);
    }
}
