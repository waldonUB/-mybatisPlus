package cn.ak.gc.service.impl;

import cn.ak.gc.commen.model.Page;
import cn.ak.gc.commen.utils.CommonDAO;
import cn.ak.gc.domain.entities.UserInfo;
import cn.ak.gc.service.LoginService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    CommonDAO<UserInfo> commonDAO;

    @Override
    public UserInfo getUserInfo(UserInfo vo) throws Exception {
        return commonDAO.getEntity(vo);
    }

    @Override
    public void addLoginUser(UserInfo userInfo) {
        userInfo.setCreationTime(new Date());
        userInfo.setLastTime(new Date());
        commonDAO.insertVOWithTB(userInfo, "sys_login_user");
    }

    @Override
    public void deleteLoginUser(UserInfo userInfo) {
        commonDAO.deleteVOWithTB(userInfo, "sys_login_user");
    }

    @Override
    public void addUser(UserInfo userInfo) {
        userInfo.setCreationTime(new Date());
        commonDAO.insertVOWithPK(userInfo);
    }

    @Override
    public void updateUser(UserInfo userInfo) {
        commonDAO.updateVO(userInfo);
    }

    @Override
    public List<UserInfo> getLoginUsers() {
        UserInfo userInfo = new UserInfo();
        return commonDAO.getEntitiesWithTB("sys_login_user", userInfo, null);
    }



    @Override
    public int deleteUser() {
        String userId = "08f038e7-e0a6-445b-8b94-937adc0f14dd";
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(userId);
        return commonDAO.deleteVO(userInfo);
    }

    @Override
    public List<UserInfo> getEntities(UserInfo vo) {
        UserInfo userInfo = new UserInfo();
        JSONObject params = new JSONObject();
//        params.put("user_name", "更新版成吉思汗");
        return commonDAO.getEntities(vo, params);
    }

    @Override
    public Page<UserInfo> getPageEntities(UserInfo vo, int current, int size) {
        return commonDAO.getPageEntities(vo, null, current, size);
    }

}
