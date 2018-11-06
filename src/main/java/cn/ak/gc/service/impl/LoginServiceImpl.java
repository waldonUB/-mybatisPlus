package cn.ak.gc.service.impl;

import cn.ak.gc.commen.model.Page;
import cn.ak.gc.commen.utils.CommonDAO;
import cn.ak.gc.domain.entities.UserInfo;
import cn.ak.gc.service.LoginService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    CommonDAO<UserInfo> commonDAO;

    @Override
    public int saveUser() {
        String uuid = UUID.randomUUID().toString();
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(uuid);
        userInfo.setUserName("成吉思汗");
        userInfo.setCreationTime(new Date());
        userInfo.setModifyTime(new Date());
        return commonDAO.insertVOWithPK(userInfo);
    }

    @Override
    public int updateUser() {
        String userId = "5772ad77-603c-4929-a454-44e82e987fa2";
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(userId);
        userInfo.setUserName("更新版成吉思汗");
        userInfo.setModifyTime(new Date());
        return commonDAO.updateVO(userInfo);
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
