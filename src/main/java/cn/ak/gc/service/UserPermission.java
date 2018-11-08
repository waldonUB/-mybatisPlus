package cn.ak.gc.service;

import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.Map;

public interface UserPermission {
    List<Map<String,Object>> queryPermissionTree(JSONObject json);
}
