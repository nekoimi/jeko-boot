package me.nekoimi.start.core.factory;

import me.nekoimi.start.annotation.aop.Aspect;
import me.nekoimi.start.annotation.api.RestController;
import me.nekoimi.start.annotation.ioc.Component;
import me.nekoimi.start.utils.ReflectionKit;

import java.lang.annotation.Annotation;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author nekoimi  2021/3/4 下午4:03
 */
public class ClassFactory {
    public static final Map<Class<? extends Annotation>, Set<Class<?>>> CLASSES = new ConcurrentHashMap<>();

    public static void loadClass(String[] packageName) {
        Set<Class<?>> restControllers = ReflectionKit.scanAnnotatedClass(packageName, RestController.class);
        Set<Class<?>> components = ReflectionKit.scanAnnotatedClass(packageName, Component.class);
        Set<Class<?>> aspects = ReflectionKit.scanAnnotatedClass(packageName, Aspect.class);

        CLASSES.put(RestController.class, restControllers);
        CLASSES.put(Component.class, components);
        CLASSES.put(Aspect.class, aspects);
    }

}
