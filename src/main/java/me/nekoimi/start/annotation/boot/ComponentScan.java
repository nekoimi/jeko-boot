package me.nekoimi.start.annotation.boot;

import java.lang.annotation.*;

/**
 * @author nekoimi  2021/3/4 下午3:00
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ComponentScan {

    String[] value() default {};

}
