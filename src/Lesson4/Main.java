package Lesson4;

public class Main {

    // 1. Создать три потока, каждый из которых выводит определенную букву (A, B и C) 5 раз (порядок – ABСABСABС).
    // Используйте wait/notify/notifyAll.
    static Object mon = new Object();

    static char currentLetter = 'A';

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
//            printA();
            printX ('A');
        });
        Thread t2 = new Thread(() -> {
//         printB();
            printX ('B');
        });
        Thread t3 = new Thread(() -> {
//         printC();
            printX ('C');
        });

        t1.start();
        t2.start();
        t3.start();


    }
    public static void printX (char a){
        synchronized (mon) {
            try {
                for (int i = 0; i <5 ; i++) {
//                    Thread.sleep(1000);
                    while (currentLetter != a) {
                        mon.wait();
                    }
                    System.out.print(a);
                    if (a == 67){
                        currentLetter = (char) (a-2);
                    } else {
                        currentLetter = (char) (a + 1);
                    }
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void printA (){
        synchronized (mon) {
            try {
                for (int i = 0; i <5 ; i++) {
                        while (currentLetter != 'A') {
                            mon.wait();
                        }
                        System.out.print("A");
                        currentLetter = 'B';
                        mon.notifyAll();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    public static void printB (){
        synchronized (mon) {
            try {
                for (int i = 0; i <5 ; i++) {
                    while (currentLetter != 'B') {
                        mon.wait();
                    }
                    System.out.print("B");
                    currentLetter = 'C';
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void printC (){
        synchronized (mon) {
            try {
                for (int i = 0; i <5 ; i++) {
                    while (currentLetter != 'C') {
                        mon.wait();
                    }
                    System.out.print("C");
                    currentLetter = 'A';
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}


