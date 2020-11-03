package Lesson5;

import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable {
    private static int CARS_COUNT;
    static {
        CARS_COUNT = 0;
    }
    private Race race;
    private int speed;
    private String name;
    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }


    public static String getWinnerName() {
        return winner.getName();
    }

    static Car winner = null;

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    public static int getReady() {
        return ready;
    }

    private static int ready;

    public static int getDone() {
        return done;
    }

    private static int done;


    static CyclicBarrier cb = new CyclicBarrier(Main.CARS_COUNT);
    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            ready++;
            cb.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        if (getWinner() == null){
            winner = this;
        }
        done++;
    }

    private Car getWinner() {
        return winner;
    }
}
