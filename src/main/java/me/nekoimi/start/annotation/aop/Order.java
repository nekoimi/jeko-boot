package me.nekoimi.start.annotation.aop;

import java.lang.annotation.*;

/**
 * @author nekoimi  2021/3/4 下午2:53
 */
@Target({
        ElementType.FIELD,
        ElementType.METHOD,
        ElementType.PARAMETER,
        ElementType.TYPE,
        ElementType.ANNOTATION_TYPE
})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Order {

    int value() default -1;

}
