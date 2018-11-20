package cn.ak.gc.commen.utils;

import cn.ak.gc.domain.entities.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class TestUtils {
    @Autowired
    CommonDAO<UserInfo> commonDAO;
    private static TestUtils testUtils;

    @PostConstruct
    public void init() {
        testUtils = this;
        testUtils.commonDAO = this.commonDAO;
    }

    public static UserInfo test() throws Exception {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("waldon");
        return testUtils.commonDAO.getEntity(userInfo);
    }
}
