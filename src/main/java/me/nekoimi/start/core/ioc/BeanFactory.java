package me.nekoimi.start.core.ioc;

import me.nekoimi.start.annotation.api.RestController;
import me.nekoimi.start.annotation.ioc.Component;
import me.nekoimi.start.core.factory.ClassFactory;
import me.nekoimi.start.utils.ReflectionKit;

import java.security.InvalidParameterException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author nekoimi  2021/3/4 下午2:45
 */
public final class BeanFactory {
    // 容器
    public static final Map<String, Object> BEANS = new ConcurrentHashMap<>();

    private static final Map<String, String[]> SINGLE_BEAN_NAMES_TYPE_MAP = new ConcurrentHashMap<>();

    public static void loadBeans() {
        Class<?>[] strings = new Class<?>[]{Component.class, RestController.class};
        for (Class<?> string : strings) {
            ClassFactory.CLASSES.get(string).forEach(BeanFactory::setBean);
        }
    }

    private static void setBean(Class<?> aClass) {
        String beanName = BeanHelper.getBeanName(aClass);
        Object instance = ReflectionKit.newInstance(aClass);
        BEANS.put(beanName, instance);
    }

    public static <T> T getBean(Class<T> clazz) {
        String[] beanNames = getBeanNamesForType(clazz);
        if (beanNames.length == 0) {
            throw new InvalidParameterException();
        }
        String beanName = beanNames[0];
        Object beanInstance = BEANS.get(beanName);
        if (!clazz.isInstance(beanInstance)) {
            throw new InvalidParameterException();
        }
        return clazz.cast(beanInstance);
    }

    public static <T> Map<String, T> getBeansOfType(Class<T> clazz) {
        Map<String, T> result = new HashMap<>();
        String[] beanNames = getBeanNamesForType(clazz);
        for (String beanName : beanNames) {
            Object beanInstance = BEANS.get(beanName);
            if (!clazz.isInstance(beanInstance)) {
                throw new InvalidParameterException(String.format("%s.isInstance(%s) is false!!!", clazz.getName(), beanName));
            }
            result.put(beanName, clazz.cast(beanInstance));
        }
        return result;
    }

    private static String[] getBeanNamesForType(Class<?> clazz) {
        String clazzName = clazz.getName();
        String[] beanNames = SINGLE_BEAN_NAMES_TYPE_MAP.get(clazzName);
        if (beanNames != null) {
            return beanNames;
        }

        List<String> beanNamesList = new ArrayList<>();
        Set<Map.Entry<String, Object>> entrySet = BEANS.entrySet();
        for (Map.Entry<String, Object> objectEntry : entrySet) {
            Class<?> beanClass = objectEntry.getValue().getClass();
            if (!clazz.isInterface()) {
                if (beanClass.isAssignableFrom(clazz)) {
                    beanNamesList.add(objectEntry.getKey());
                }
            } else {
                Class<?>[] interfaces = beanClass.getInterfaces();
                for (Class<?> anInterface : interfaces) {
                    if (clazz.getName().equals(clazzName)) {
                        beanNamesList.add(objectEntry.getKey());
                        break;
                    }
                }
            }
        }
        beanNames = beanNamesList.toArray(new String[0]);
        SINGLE_BEAN_NAMES_TYPE_MAP.put(clazzName, beanNames);
        return beanNames;
    }

}
