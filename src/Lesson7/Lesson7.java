package Lesson7;

// Создать класс, который может выполнять «тесты».
// В качестве тестов выступают классы с наборами методов с аннотациями @Test.
// Для этого у него должен быть статический метод start(), которому в качестве параметра передается или объект типа Class,
// или имя класса. Из «класса-теста» вначале должен быть запущен метод с аннотацией @BeforeSuite, если такой имеется.
// Далее запущены методы с аннотациями @Test, а по завершении всех тестов – метод с аннотацией @AfterSuite.
// К каждому тесту необходимо добавить приоритеты (int числа от 1 до 10), в соответствии с которыми будет выбираться порядок их выполнения.
// Если приоритет одинаковый, то порядок не имеет значения. Методы с аннотациями @BeforeSuite и @AfterSuite должны присутствовать
// в единственном экземпляре, иначе необходимо бросить RuntimeException при запуске «тестирования».

import java.lang.reflect.InvocationTargetException;

public class Lesson7 {

//    private static Class Test1;

    public static void main (String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Testing mainnn = new Testing();
        Object test1 = new Test1();
        Object test2 = new Test2();
        mainnn.start(test1);
        mainnn.start(test2);


    }
}