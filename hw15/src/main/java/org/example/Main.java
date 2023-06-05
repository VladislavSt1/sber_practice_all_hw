package org.example;

public class Main {
    public static void main(String[] args) {
        int numOfPhilosophers = 5;

        Fork[] forks = new Fork[numOfPhilosophers];
        Philosopher[] philosophers = new Philosopher[numOfPhilosophers];
        Thread[] threads = new Thread[numOfPhilosophers];

        // Создание вилок
        for (int i = 0; i < numOfPhilosophers; i++) {
            forks[i] = new Fork();
        }

        // Создание философов и запуск их потоков
        for (int i = 0; i < numOfPhilosophers; i++) {
            philosophers[i] = new Philosopher(i, forks[i], forks[(i + 1) % numOfPhilosophers]);
            threads[i] = new Thread(philosophers[i]);
            threads[i].start();
        }
    }
}
