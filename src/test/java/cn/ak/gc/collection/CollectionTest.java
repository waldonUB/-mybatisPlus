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
}
