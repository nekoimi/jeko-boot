package me.nekoimi.start.annotation.config;

import java.lang.annotation.*;

/**
 * @author nekoimi  2021/3/4 下午3:05
 */
@Target({
        ElementType.TYPE,
        ElementType.METHOD
})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ConfigurationProperties {

    /**
     * configuration prefix
     *
     * Example:
     *
     *      "sms.aliyun"
     *
     * @return
     */
    String value() default "";

    /**
     * 忽略错误的字段， 默认不忽略
     * @return
     */
    boolean ignoreInvalidFields() default false;

    /**
     * 忽略未知字段， 默认忽略
     * @return
     */
    boolean ignoreUnknownFields() default true;

}
