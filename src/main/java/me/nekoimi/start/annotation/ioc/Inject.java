package me.nekoimi.start.annotation.ioc;

import java.lang.annotation.*;

/**
 * @author nekoimi  2021/3/4 下午3:22
 */
@Target({
        ElementType.FIELD,
        ElementType.PARAMETER
})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Inject {

    String value() default "";

}
