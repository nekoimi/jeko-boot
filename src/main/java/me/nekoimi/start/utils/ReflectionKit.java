package me.nekoimi.start.utils;

import lombok.extern.slf4j.Slf4j;
import org.reflections.Reflections;
import org.reflections.scanners.TypeAnnotationsScanner;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

/**
 * @author nekoimi  2021/3/2 下午4:50
 */
@Slf4j
public class ReflectionKit {

    /**
     * 扫描指定包下面标记指定注解的类集合
     *
     * @param packageNames 包名
     * @param annotation   注解类
     * @return
     */
    public static Set<Class<?>> scanAnnotatedClass(String[] packageNames, Class<? extends Annotation> annotation) {
        Reflections reflections = new Reflections(packageNames, new TypeAnnotationsScanner());
        Set<Class<?>> annotatedClass = reflections.getTypesAnnotatedWith(annotation, true);
        log.info("The number of class Annotated with @" + annotation.getSimpleName() + ":[{}]", annotatedClass.size());
        return annotatedClass;
    }

    /**
     * 获取指定接口实现类
     *
     * @param packageNames   包名
     * @param interfaceClass 接口类
     * @param <T>
     * @return
     */
    public static <T> Set<Class<? extends T>> getInterfaceImplClass(Object[] packageNames, Class<T> interfaceClass) {
        Reflections reflections = new Reflections(packageNames);
        return reflections.getSubTypesOf(interfaceClass);
    }

    /**
     * 创建指定类的对象实例
     *
     * @param clazz
     * @return
     */
    public static Object newInstance(Class<?> clazz) {
        try {
            return clazz.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new IllegalStateException(e.getMessage(), e);
        }
    }


    /**
     * 为某个实例的属性设置值
     *
     * @param obj
     * @param field
     * @param value
     */
    public static void setField(Object obj, Field field, Object value) {
        field.setAccessible(true);
        try {
            field.set(obj, value);
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        }
    }

    /**
     * 执行指定方法
     *
     * @param targetObject
     * @param method
     * @param args
     * @return
     */
    public static Object executeTargetMethod(Object targetObject, Method method, Object... args) {
        try {
            return method.invoke(targetObject, args);
        } catch (IllegalAccessException | InvocationTargetException e) {
            if (e.getCause() == null) {
                e.getCause();
            }
        }
        return null;
    }

    public static void executeTargetMethodNoResult(Object targetObject, Method method, Object... args) {
        try {
            method.invoke(targetObject, args);
        } catch (IllegalAccessException | InvocationTargetException e) {
            // ignore
        }
    }

}
