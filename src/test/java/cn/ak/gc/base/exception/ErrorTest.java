package cn.ak.gc.base.exception;

import cn.ak.gc.domain.entities.UserInfo;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ErrorTest {
    @Test
    public void outOfMemoryErrorTest() {
        List<String> list = new ArrayList<>();
        Map<Integer, Object> map = new HashMap<>();
        for (int i = 0; ; i++) {
//            list.add("wwww");
            map.put(i, "w");
        }
    }

    @Test
    public void stackOverFlowErrorTest() {
        test();
    }

    private void test() {
        List<UserInfo> list = new ArrayList<>();
        for (int i = 0; ; i++) {
            list.add(new UserInfo());
            String str = new String("w");
        }
    }
}
