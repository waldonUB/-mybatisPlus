package cn.ak.gc.controller;

import cn.ak.gc.domain.vo.ReturnModel;
import cn.ak.gc.service.UserPermission;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/gc/permission")
public class PermissionController {

    @Autowired
    UserPermission permission;

    /**
     * 根据用户拥有的节点权限生成导航栏节点
     * @param json 1.group_code 用户所属的用户组编码
     * */
    @RequestMapping("/queryPermissionTree")
    @ResponseBody
    public ReturnModel queryPermissionTree (@RequestBody JSONObject json) {
        ReturnModel model = new ReturnModel();
        List<Map<String, Object>> list = permission.queryPermissionTree(json);
        model.setSuccess(true);
        model.setData(list);
        return model;
    }
}
