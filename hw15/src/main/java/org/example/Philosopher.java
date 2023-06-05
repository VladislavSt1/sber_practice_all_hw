package org.example;

public class Philosopher implements Runnable {
    private int id;
    private Fork leftFork;
    private Fork rightFork;

    public Philosopher(int id, Fork leftFork, Fork rightFork) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    private void think() {
        System.out.println("Philosopher " + id + " is thinking.");
        // реализация размышлений
        try {
            Thread.sleep((long) (Math.random() * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void eat() {
        System.out.println("Philosopher " + id + " is eating.");
        // реализация приема пищи
        try {
            Thread.sleep((long) (Math.random() * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            think();

            // Блокировка вилок
            synchronized (leftFork) {
                System.out.println("Philosopher " + id + " picked up left fork.");
                synchronized (rightFork) {
                    System.out.println("Philosopher " + id + " picked up right fork and is eating.");
                    eat();
                }
                System.out.println("Philosopher " + id + " put down right fork.");
            }
            System.out.println("Philosopher " + id + " put down left fork.");
        }
    }
}
