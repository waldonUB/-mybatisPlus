package cn.ak.gc.commen.utils;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

//@Order(value = 1) // 指定执行顺序
@Aspect
@Component
public class SecurityAspect {


    @Pointcut(value = "@annotation(org.springframework.transaction.annotation.Transactional)")
    public void transactionalPointcut() {

    }

    @Pointcut("execution(* cn.ak.gc.service..*.*(..))")
    public void matchType() {

    }

    @Before(value = "transactionalPointcut()")
    public void transactionalBefore() {
        System.out.println("我是transactionalBefore方法");
    }

    @Before("matchType()")
    public void before() {
        System.out.println("我是before方法");
    }

//    @Before("matchType() && args(account,..)")
//    public void before(String account) {
//        System.out.println(account);
//        System.out.println("我是before方法");
//    }

//    @AfterThrowing(value = "matchType()", throwing = "ex")
//    public void throwTest(DataAccessException ex) { // throwing 子句也限制了只能匹配到抛出指定类型的异常
//
//    }
}
