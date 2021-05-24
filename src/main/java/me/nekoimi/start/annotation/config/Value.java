package me.nekoimi.start.annotation.config;

import java.lang.annotation.*;

/**
 * @author nekoimi  2021/3/4 下午3:09
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Value {

    /**
     * Example:
     *
     *    "sms.aliyun"
     *
     * @return
     */
    String value() default "";

}
