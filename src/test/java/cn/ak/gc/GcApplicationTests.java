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

	public String upperCase(String str) {
		char[] ch = str.toCharArray();
		if (ch[0] >= 'a' && ch[0] <= 'z') {
			ch[0] = (char) (ch[0] - 32);
		}
		return new String(ch);
	}

	public String lowerCase(String str) {
		char[] ch = str.toCharArray();
		int num = 0;
		for (char aCh : ch) {
			if (aCh >= 'A' && aCh <= 'Z') {
				num++;
			}
		}
		char[] chNew = new char[ch.length + num];
		int flag = 0;
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] >= 'a' && ch[i] <= 'z') {
				chNew[i + flag] = ch[i];
			} else if (ch[i] >= 'A' && ch[i] <= 'Z') {
				chNew[i + flag] = '_';
				chNew[i + flag + 1] = (char) (ch[i] + 32);
				flag++;
			}
		}
		return new String(chNew);
	}

	@Test
	public void spiltTest() {
		String name = "user";
		String[] splits = name.split("_");
		StringBuffer newName = new StringBuffer(splits[0]);
		for (int i = 1; i < splits.length; i++) {
			newName.append(upperCase(splits[i]));
		}
		System.out.println(newName);
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

	@Test
	public void testList() {
		List list = new ArrayList();
		list.add(1);
		list.add(2);
		List list2 = new ArrayList();
		list2.add(3);
		list2.add(4);
		list.forEach(item -> {
			list2.forEach(item2 -> {

			});
		});
	}
}
