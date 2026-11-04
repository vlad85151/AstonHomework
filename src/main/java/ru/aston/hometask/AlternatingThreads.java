package ru.aston.hometask;

public class AlternatingThreads {

    private static final Object lock = new Object();

    private static boolean firstThreadTurn = true;

    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {
            while (true) {
                synchronized (lock) {

                    while (!firstThreadTurn) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }

                    System.out.println("1");

                    firstThreadTurn = false;

                    lock.notifyAll();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            while (true) {
                synchronized (lock) {

                    while (firstThreadTurn) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }

                    System.out.println("2");

                    firstThreadTurn = true;

                    lock.notifyAll();
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}