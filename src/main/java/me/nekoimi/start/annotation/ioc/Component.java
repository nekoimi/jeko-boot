package me.nekoimi.start.annotation.ioc;

import java.lang.annotation.*;

/**
 * @author nekoimi  2021/3/4 下午3:21
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Component {

    String name() default "";

}
