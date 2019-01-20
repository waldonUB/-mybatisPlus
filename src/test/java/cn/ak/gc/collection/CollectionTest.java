package cn.ak.gc.collection;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
}
