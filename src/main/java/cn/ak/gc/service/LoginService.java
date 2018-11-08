package cn.ak.gc.service;

import cn.ak.gc.commen.model.Page;
import cn.ak.gc.domain.entities.UserInfo;

import java.util.List;

public interface LoginService {
    UserInfo getUserInfo(UserInfo userInfo) throws Exception;
    void addLoginUser(UserInfo userInfo);
    void deleteLoginUser(UserInfo userInfo);
    void addUser(UserInfo userInfo);
    void updateUser(UserInfo userInfo);
    int saveUser();
    int deleteUser();
    List<UserInfo> getEntities(UserInfo userInfo);
    Page<UserInfo> getPageEntities(UserInfo userInfo, int current, int size);


}
