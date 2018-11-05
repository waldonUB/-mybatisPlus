package cn.ak.gc.commen.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Inherited
public @interface Entity {
    String tableName();
    String primaryKey();
}
