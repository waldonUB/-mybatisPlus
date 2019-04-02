package cn.ak.gc.commen.session;

import cn.ak.gc.commen.utils.CommonDAO;
import cn.ak.gc.domain.entities.UserInfo;
import cn.ak.gc.domain.repository.CommonRepository;
import cn.ak.gc.service.LoginService;
import cn.ak.gc.service.impl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.io.FileNotFoundException;

//@Service
public class SessionListener implements HttpSessionListener, HttpSessionAttributeListener {

    @Autowired
    LoginServiceImpl loginService;
//    private static SessionListener sessionListener;
//
//    @PostConstruct
//    public void init() {
//        sessionListener = this;
//        sessionListener.loginService = this.loginService;
//    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        System.out.println("session创建了");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.out.println("session销毁了");
        UserInfo userInfo = (UserInfo) httpSessionEvent.getSession().getAttribute("sessionKey");
        if (userInfo != null) {
            try {
                loginService.deleteLoginUser(userInfo);
//            sessionListener.loginService.deleteLoginUser(userInfo);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("attributeAdded增加啦");
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("attributeRemoved移除了");
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {

    }
}
