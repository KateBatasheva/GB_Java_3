package Lesson7;

public class Test1 {

     @BeforeSuite (priority = 0)
        public void before() {
            System.out.println("Подготовка тест 1");
        }

        @AfterSuite (priority = Integer.MAX_VALUE)
        public void after() {
            System.out.println("Окончание теста 1");
        }

        @Test(priority = 1)
        public void test1() {
            System.out.println("Запущен тест 1.1");
        }

        @Test(priority = 2)
        public void test2() {
            System.out.println("Запущен тест 1.2");

        }

        @Test(priority = 3)
        public void test3() {
            System.out.println("Запущен тест 1.3");

        }
    }


