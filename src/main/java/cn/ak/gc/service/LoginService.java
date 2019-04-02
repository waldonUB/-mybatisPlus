package cn.ak.gc.service;

import cn.ak.gc.commen.model.Page;
import cn.ak.gc.domain.entities.UserInfo;

import java.io.FileNotFoundException;
import java.util.List;

public interface LoginService {
    UserInfo getUserInfo(UserInfo userInfo) throws Exception;
    void addLoginUser(UserInfo userInfo);
    void deleteLoginUser(UserInfo userInfo) throws FileNotFoundException;
    void addUser(UserInfo userInfo);
    void updateUser(UserInfo userInfo) throws FileNotFoundException;
    List<UserInfo> getLoginUsers();
    int deleteUser();
    List<UserInfo> getEntities(UserInfo userInfo);
    Page<UserInfo> getPageEntities(UserInfo userInfo, int current, int size);


}
