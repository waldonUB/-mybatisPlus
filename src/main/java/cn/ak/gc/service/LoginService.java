package cn.ak.gc.service;

import cn.ak.gc.domain.entities.UserInfo;

import java.util.List;

public interface LoginService {
    int saveUser();
    int updateUser();
    int deleteUser();
    List<UserInfo> getEntities(UserInfo vo);
}
