package cn.ak.gc;

import cn.ak.gc.commen.annotation.Column;
import cn.ak.gc.commen.annotation.Entity;
import cn.ak.gc.domain.entities.UserInfo;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GcApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void redisSession() {
	}

	@Test
	public void getMethods() {
		// ((AnnotationInvocationHandler)((Proxy)userInfo.getClass().getAnnotations()[0]).h).memberValues.get("name")
		UserInfo userInfo = new UserInfo();
		Method[] methods = userInfo.getClass().getMethods();
		Field[] fields = userInfo.getClass().getDeclaredFields();
		for (Field field : fields) {
			String column = field.getAnnotation(Column.class).column();
		}
		Column columns = userInfo.getClass().getDeclaredAnnotation(Column.class);
		Entity entities = userInfo.getClass().getAnnotation(Entity.class);
		Annotation[] annotations = userInfo.getClass().getDeclaredAnnotations();// ((AnnotationInvocationHandler) ((Proxy) annotations[0]).h).memberValues.get("name")
        Map<String, Object> map = new HashMap<>();
        map.put("name", "xixix");
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(userInfo);
        Set<String> keys = map.keySet();
        Collection collection = map.values();
		keys.forEach((item) -> {});
		map.forEach((key, value) -> {
			System.out.println("key:" + key);
			System.out.println("value:" + value);
		});
		Entity entity = userInfo.getClass().getAnnotation(Entity.class);
		String name = entity.tableName();
	}

	/**
	 * map的hash值的方法是判断里面每个key和值相不相等
	 * model的hash值不会重复
	 * */
	@Test
	public void hashTest() {
		UserInfo userInfo = new UserInfo();
		UserInfo userInfo1 = new UserInfo();
		userInfo.setUserName("wdq");
		userInfo1.setUserName("wdq");
		Map<String, Object> map = new HashMap<>();
		map.put("name", "wdq");
		Map<String, Object> map2 = new HashMap<>();
		map2.put("name", "wdq");
		System.out.println(map2.hashCode());
		System.out.println(userInfo1.hashCode());
		List<Map<String, Object>> list = new ArrayList<>();
		list.add(map);
		list.add(map2);
		List<Map<String, Object>> list2 = list.stream().distinct().collect(Collectors.toList());
		System.out.println(userInfo.hashCode());
		System.out.println(userInfo1.hashCode());
		List<UserInfo> list3 = new ArrayList<>();
		list3.add(userInfo);
		list3.add(userInfo1);
		List<UserInfo> list4 = list3.stream().distinct().collect(Collectors.toList());
	}

}
