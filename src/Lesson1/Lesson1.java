package Lesson1;

import Lesson1.BigTask.Apple;
import Lesson1.BigTask.Box;
import Lesson1.BigTask.Orange;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lesson1 {
    public static void main(String[] args) {
        // 1
        String[] arrStr = new String[]{"mmmm", "gggg", "zzzz"};
        System.out.println(Arrays.toString(change(arrStr, 0, 2)));
        Integer[] arrInt = new Integer[]{1, 2, 3};
        System.out.println(Arrays.toString(change(arrInt, 0, 2)));

        // 2
        ArrayList arrayList = transferToArraylist(arrStr);
        ArrayList arrayList1 = transferToArraylist2(arrInt);
        System.out.println(arrayList.toString());
        System.out.println(arrayList1.toString());
        System.out.println(arrayList instanceof ArrayList);
        System.out.println(arrayList1 instanceof ArrayList);

        // 3
        Box<Apple> appleBox = new Box<>();
        Box<Apple> appleBox2 = new Box<>();
        Box<Orange> orangeBox = new Box<>();
        appleBox.put(new Apple());
        appleBox.put(new Apple());
        appleBox2.put(new Apple());
        appleBox2.put(new Apple());
        System.out.printf("Вес коробки = %f\n", appleBox.getWeight());
        orangeBox.put(new Orange());
        orangeBox.put(new Orange());
        System.out.printf("Вес коробки = %f\n", orangeBox.getWeight());
        System.out.println(appleBox.compare(orangeBox));
        appleBox.change(appleBox2);
        System.out.println(appleBox.getWeight());
        System.out.println(appleBox2.getWeight());

        Thread t = new Thread();
        Thread t1 = new Thread(t);
    }
    // 1. Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);

    public static <T> T[] change(T[] arr, int index1, int index2) {
        try {
            T a = arr[index1];
            arr[index1] = arr[index2];
            arr[index2] = a;
            System.out.println("Массив изменен");
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("Некорректные индексы. Массив не изменен");
        }
        return arr;
    }

    // 2. Написать метод, который преобразует массив в ArrayList;

    public static <T> ArrayList transferToArraylist(T[] arr) {
        return new ArrayList(Arrays.asList(arr));
    }

    public static <T> ArrayList transferToArraylist2(T[] arr) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < arr.length; i++) {
            arrayList.add(arr[i]);
        }
        return arrayList;
    }
}