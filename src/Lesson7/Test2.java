package Lesson7;

public class Test2 {
    @BeforeSuite(priority = 0)
    public void before() {
        System.out.println("Подготовка тест 2");
    }

    @AfterSuite(priority = Integer.MAX_VALUE)
    public void after() {
        System.out.println("Окончание теста 2");
    }

    @Test(priority = 1)
    public void test1() {
        System.out.println("Запущен тест 2.1");
    }

    @Test(priority = 2)
    public void test2() {
        System.out.println("Запущен тест 2.2");

    }

    @Test(priority = 1)
    public void test3() {
        System.out.println("Запущен тест 2.3");

    }
}
