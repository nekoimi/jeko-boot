package me.nekoimi.start.annotation.api;

import me.nekoimi.start.annotation.ioc.Component;

import java.lang.annotation.*;

/**
 * @author nekoimi  2021/3/4 下午4:01
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface RestController {
    String value() default "";
}
