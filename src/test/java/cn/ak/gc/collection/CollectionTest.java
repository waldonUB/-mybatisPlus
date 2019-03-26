package cn.ak.gc.collection;

import cn.ak.gc.domain.entities.UserInfo;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class CollectionTest {
    @Test
    public void mapFor() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "waldon");
        List<Object> list = map.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            System.out.println();
        }
    }

    @Test
    public void mapTest() {
        Map<String, Object> map = new HashMap<>();
        Collection<Object> collection = map.values();
        List<String> list = new ArrayList<>();
    }

    @Test
    public void iteratorTest() {
        List<String> list = new ArrayList<>();
        Iterator iterator = list.iterator();
        Object object = new Object();
        int i = 1;
        UserInfo userInfo = new UserInfo();
        userInfo.equals(object);

    }

    // 测试每次增加会不会改变hashCode? 会  且相同的hashMap，HashCode会相同
    @Test
    public void HashCodeTest() {
        HashMap<String, Object> map = new HashMap<>();
        map.hashCode();
        System.out.println("map" + map.hashCode());
        map.put("name", "w4");
        System.out.println("map" + map.hashCode());
        map.put("password", "w");
        System.out.println("map" + map.hashCode());
        map.put("password", "w");
        System.out.println("map" + map.hashCode());
        HashMap<String, Object> map1 = new HashMap<>();
        System.out.println("map1" + map1.hashCode());
        map1.put("name", "w4");
        System.out.println("map1:" + map1.hashCode());
        map1.put("password", "w");
        System.out.println("map1:" + map1.hashCode());
        map1.put("password", "w");
        System.out.println("map1:" + map1.hashCode());
        System.out.println(map.equals(map1));
    }

    // 判断对象  每次增加，hashCode都不会变
    @Test
    public void judgeObject() {
        UserInfo userInfo = new UserInfo();
        System.out.println("userInfo:" + userInfo.hashCode());
        userInfo.setUserName("w");
        System.out.println("userInfo:" + userInfo.hashCode());
        userInfo.setPassword("w");
        System.out.println("userInfo:" + userInfo.hashCode());
        UserInfo userInfo1 = new UserInfo();
        System.out.println("userInfo1:" + userInfo1.hashCode());
        userInfo1.setUserName("w");
        System.out.println("userInfo1:" + userInfo1.hashCode());
        userInfo1.setPassword("w");
        System.out.println("userInfo1:" + userInfo1.hashCode());
    }

    @Test
    public void linkListTest() {
        List list = new LinkedList();
    }
}
