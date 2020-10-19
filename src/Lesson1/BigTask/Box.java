package Lesson1.BigTask;

import com.sun.org.apache.xalan.internal.xsltc.dom.SimpleResultTreeImpl;

import java.util.ArrayList;
import java.util.Arrays;

public class Box <T extends Fruit> {
    private ArrayList<T> boxFruit = new ArrayList<>();


    public void put(T fruit) {
        boxFruit.add(fruit);
    }

    public float getWeight() {
        float wight =0f;
        for (int i = 0; i <boxFruit.size() ; i++) {
            wight += boxFruit.get(i).getWight();
        } return wight;
    }

    public boolean compare (Box <? extends Fruit> o) {
        return Math.abs(o.getWeight() - this.getWeight()) < 0.0001f;
    }

    public void change (Box <T> o) {
        while (o.boxFruit.size() > 0) {
            boxFruit.add(o.boxFruit.get(o.boxFruit.size() - 1));
            o.boxFruit.remove(o.boxFruit.size() - 1);
        }
    }
}
