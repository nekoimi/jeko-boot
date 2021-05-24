package me.nekoimi.start.annotation.api;

import java.lang.annotation.*;

/**
 * @author nekoimi  2021/3/4 下午3:27
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PutMapping {

    String value() default "";

}
