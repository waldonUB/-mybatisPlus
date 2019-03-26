package cn.ak.gc.service;

import cn.ak.gc.domain.entities.UserInfo;

import java.util.List;

public interface AdminService {
    void deleteUser(String userId);
    List<UserInfo> getUserList();
}
