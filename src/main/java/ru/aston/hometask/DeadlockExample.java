package ru.aston.hometask;

import java.util.concurrent.CountDownLatch;

public class DeadlockExample {

    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    private static final CountDownLatch ready = new CountDownLatch(2);

    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Поток 1 захватил lock1");

                ready.countDown();
                waitForOtherThread();

                synchronized (lock2) {
                    System.out.println("Поток 1 захватил lock2");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("Поток 2 захватил lock2");

                ready.countDown();
                waitForOtherThread();

                synchronized (lock1) {
                    System.out.println("Поток 2 захватил lock1");
                }
            }
        });

        thread1.start();
        thread2.start();
    }

    private static void waitForOtherThread() {
        try {
            ready.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}