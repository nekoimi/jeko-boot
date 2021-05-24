package me.nekoimi.start.core.ioc;

import me.nekoimi.start.annotation.ioc.Component;

/**
 * @author nekoimi  2021/3/4 下午4:12
 */
public class BeanHelper {

    /**
     * @param aClass
     * @return
     */
    public static String getBeanName(Class<?> aClass) {
        String beanName = aClass.getName();
        if (aClass.isAnnotationPresent(Component.class)) {
            Component component = aClass.getAnnotation(Component.class);
            beanName = "".equals(component.name()) ? aClass.getName() : component.name();
        }
        return beanName;
    }

}
