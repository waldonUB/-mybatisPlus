package cn.ak.gc.j8Test;

import cn.ak.gc.TypeTest;
import cn.ak.gc.domain.entities.UserInfo;
import org.junit.Test;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class J8Test {
    private static int i = 0;
    @Test
    public void entityTest() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("吴德钦");
        Map<String, Object> map = new HashMap<>();
        map.put("name", "吴德钦");
        map.forEach((key ,value) -> {
            System.out.println("key" + key);
            System.out.println("value" + value);
        });
    }

    @Test
    public void test01() {

    }

}
