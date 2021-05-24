package me.nekoimi.start.annotation.api;

import java.lang.annotation.*;

/**
 * @author nekoimi  2021/3/4 下午3:55
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface RequestBody {
}
