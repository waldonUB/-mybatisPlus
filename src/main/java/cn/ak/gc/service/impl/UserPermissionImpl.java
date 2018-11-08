package cn.ak.gc.service.impl;

import cn.ak.gc.domain.repository.PermissionRepository;
import cn.ak.gc.service.UserPermission;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserPermissionImpl implements UserPermission {

    @Autowired
    PermissionRepository permissionRepository;

    @Override
    public List<Map<String, Object>> queryPermissionTree(JSONObject json) {
        String groupCode = json.getString("groupCode");
        return permissionRepository.queryPermissionTree(groupCode);
    }
}
