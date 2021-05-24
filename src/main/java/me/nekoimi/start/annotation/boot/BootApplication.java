package me.nekoimi.start.annotation.boot;

import java.lang.annotation.*;

/**
 * @author nekoimi  2021/3/4 下午3:02
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@ComponentScan
@Inherited
@Documented
public @interface BootApplication {
}
