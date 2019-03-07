package cn.ak.gc.collection;

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
    public void mapTest(Map.Entry<String, Object> entry) {
        Map<String, Object> map = new HashMap<>();
        Collection<Object> collection = map.values();
        List<String> list = new ArrayList<>();
    }

    @Test
    public void iteratorTest() {
        List<String> list = new ArrayList<>();
        Iterator iterator = list.iterator();
    }
}
