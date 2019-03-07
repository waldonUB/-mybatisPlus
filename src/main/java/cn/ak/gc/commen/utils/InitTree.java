package cn.ak.gc.commen.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 构造树形菜单
 * */
public class InitTree<T> {

    /**
     * 构造根节点并添加剩余节点的数据
     * */
    public static<T> List<T> getRootNodes(List<T> allList) {
        Class<T> currentClass = (Class<T>) allList.get(0).getClass();
        // 需转成泛型为JSONObject的list,JSONArray直接forEach不能提供对应泛型内的方法
        List<JSONObject> allArray = JSONArray.parseArray(JSON.toJSONString(allList), JSONObject.class);
        JSONArray rootArray = allArray.stream()
                .filter(sysMenu -> {
                    JSONObject json = JSONObject.parseObject(JSON.toJSONString(sysMenu));
                    String parentId = json.getString("parentId");
                    return StringUtils.isEmpty(parentId);
                }).collect(Collectors.toCollection(JSONArray::new));
        List<JSONObject> rootList = JSONArray.parseArray(rootArray.toJSONString(), JSONObject.class);
        addSubNodes(allArray, rootList);
        allList = JSONArray.parseArray(JSON.toJSONString(rootList), currentClass); // 返回全部节点构造成的数据
        return allList;
    }

    /**
     * 从第二层节点开始的递归方法
     * */
    private static void addSubNodes(List<JSONObject> allArray, List<JSONObject> rootList) {
        rootList.forEach(item -> allArray.forEach(subItem -> {
            String rootId = item.getString("id");
            String subParentId = subItem.getString("parentId");
            if (rootId.equals(subParentId)) {
                List<JSONObject> subArray;
                if (!CollectionUtils.isEmpty(item.getJSONArray("subMenu"))) {
                    subArray = JSONArray.parseArray(JSON.toJSONString(item.getJSONArray("subMenu")), JSONObject.class);
                } else {
                    subArray = new ArrayList<>();
                }
                subArray.add(subItem);
                item.put("subMenu", subArray.stream().distinct().collect(Collectors.toList())); // 去除重复遍历的节点
                addSubNodes(allArray, subArray);
            }
        }));
    }
}
