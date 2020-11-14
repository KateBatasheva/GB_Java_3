package Lesson7;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class Testing {

    public static void start(Object test) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class mt = test.getClass();
        Method[] met = mt.getDeclaredMethods();
        Set<Method> methods = new HashSet<>(Arrays.asList(met));
        HashMap<Method, Integer> mapMeth = new HashMap<>();
        for (int i = 0; i < met.length; i++) {
            Integer count = mapMeth.getOrDefault(met[i], 0);
            mapMeth.put(met[i], count + 1);
        }
        List <Method> methList = new ArrayList<>();

       try {
               if (mapMeth.get(mt.getMethod("before")) != 1) {
                   throw new RuntimeException("Неверное количество методов с аннотацией BeforeSuite");
               }
               if (mapMeth.get(mt.getMethod("after")) != 1) {
                   throw new RuntimeException("Неверное количество методов с аннотацией AfterSuite");
           }
           for (Method m : met) {
              if (m.isAnnotationPresent(Test.class)){
                  methList.add(m);
              }
           }
           methList.sort(Comparator.comparingInt((Method i) -> i.getAnnotation(Test.class).priority()));
           methList.add(0,mt.getMethod("before"));
           methList.add(mt.getMethod("after"));
       } catch (RuntimeException e) {
           e.printStackTrace();
       }
        for (Method method : methList) {
            method.invoke(test);
        }

        }

    }



