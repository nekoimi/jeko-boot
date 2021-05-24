package me.nekoimi.start.annotation.api;

import me.nekoimi.start.request.enums.HttpMethod;

import java.lang.annotation.*;

/**
 * @author nekoimi  2021/3/4 下午3:39
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestMapping {

    /**
     * http method
     * @return
     */
    HttpMethod method() default HttpMethod.GET;

    /**
     * http route
     * @return
     */
    String value() default "";

}
