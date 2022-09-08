package cz.spsmb.ctvrtak.b_anotace;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.util.ClassUtils;

import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

/***
 * https://www.baeldung.com/java-scan-annotations-runtime
 */
@SampleAnnotation(name = "annotatedClass")
public class EPrikladRuntimeAnotace {
    @SampleAnnotation(name = "annotatedMethod")
    public void annotatedMethod() {
        //Do something
    }

    public void notAnnotatedMethod() {
        //Do something
    }
    @Test
    public void testWithJavaReflection() throws ClassNotFoundException {
        Class<?> clazz = ClassLoader.getSystemClassLoader().loadClass("cz.spsmb.ctvrtak.b_anotace.EPrikladRuntimeAnotace");
        SampleAnnotation classAnnotation = clazz.getAnnotation(SampleAnnotation.class);
        Assertions.assertEquals("annotatedClass", classAnnotation.name());
        Method[] methods = clazz.getMethods();
        List<String> annotatedMethods = new ArrayList<>();
        for (Method method : methods) {
            SampleAnnotation annotation = method.getAnnotation(SampleAnnotation.class);
            if (annotation != null) {
                annotatedMethods.add(annotation.name());
            }
        }
        Assertions.assertEquals(1, annotatedMethods.size());
        Assertions.assertEquals("annotatedMethod", annotatedMethods.get(0));
    }
    // Pomocí frameworku Spring můžeme číst třídy, bez znalosti jejich názvu.
    @Test
    public void testWithSpringContext(){
        ClassPathScanningCandidateComponentProvider provider =
                new ClassPathScanningCandidateComponentProvider(false);
        provider.addIncludeFilter(new AnnotationTypeFilter(SampleAnnotation.class));

        Set<BeanDefinition> beanDefs = provider
                .findCandidateComponents("cz.spsmb.ctvrtak.b_anotace.EPrikladRuntimeAnotace");
        List<String> annotatedBeans = new ArrayList<>();
        for (BeanDefinition bd : beanDefs) {
            if (bd instanceof AnnotatedBeanDefinition) {
                Map<String, Object> annotAttributeMap = ((AnnotatedBeanDefinition) bd)
                        .getMetadata()
                        .getAnnotationAttributes(SampleAnnotation.class.getCanonicalName());
                annotatedBeans.add(annotAttributeMap.get("name").toString());
            }
        }
        Assertions.assertEquals(1, annotatedBeans.size());
        Assertions.assertEquals("EPrikladRuntimeAnotace", annotatedBeans.get(0));
    }
    // With the help of AnnotationUtils and ClassUtils,
    // it's possible to find the methods and classes annotated with a specific annotation.
    @Test
    public void testWithSpringCore() {
        Class<?> userClass = ClassUtils.getUserClass(EPrikladRuntimeAnotace.class);

        List<String> annotatedMethods = Arrays.stream(userClass.getMethods())
                .filter(method -> AnnotationUtils
                        .getAnnotation(method, SampleAnnotation.class) != null)
                .map(method -> method.getAnnotation(SampleAnnotation.class)
                        .name())
                .collect(Collectors.toList());

        Assertions.assertEquals(1, annotatedMethods.size());
        Assertions.assertEquals("annotatedMethod", annotatedMethods.get(0));
    }
    //Reflections is a library that is said to be written in the spirit of Scannotations library.
    // It scans and indexes the project's classpath metadata.
    @Test
    public void testWithReflection(){
        Reflections reflections = new Reflections("com.baeldung.annotation.scanner");

        Set<Method> methods = reflections
                .getMethodsAnnotatedWith(SampleAnnotation.class);
        List<String> annotatedMethods = methods.stream()
                .map(method -> method.getAnnotation(SampleAnnotation.class)
                        .name())
                .collect(Collectors.toList());

        Assertions.assertEquals(1, annotatedMethods.size());
        Assertions.assertEquals("annotatedMethod", annotatedMethods.get(0));

        Set<Class<?>> types = reflections
                .getTypesAnnotatedWith(SampleAnnotation.class);
        List<String> annotatedClasses = types.stream()
                .map(clazz -> clazz.getAnnotation(SampleAnnotation.class)
                        .name())
                .collect(Collectors.toList());

        Assertions.assertEquals(1, annotatedClasses.size());
        Assertions.assertEquals("SampleAnnotatedClass", annotatedClasses.get(0));
    }
}
