package cn.ak.gc;

import org.junit.Test;
import org.springframework.util.StringUtils;

public class TypeTest<T> extends RedisTest{

    @Test
    public void testCalculate() {
        int i = 3; // 1.右移:从右边开始减,不够位数则变为0  2.左移:从右边开始加0,实际是3 * 2的n次方
        int j = i>>3;
        System.out.println(j);
    }
}
