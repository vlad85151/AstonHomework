package ru.aston.hometask;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.ReentrantLock;

public class LivelockExample {

    private static final ReentrantLock lock1 = new ReentrantLock();
    private static final ReentrantLock lock2 = new ReentrantLock();

    private static final CyclicBarrier barrier = new CyclicBarrier(2);

    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {

                lock1.lock();

                try {
                    awaitBarrier();

                    if (!lock2.tryLock()) {
                        System.out.println("Поток 1: lock2 занят, уступаю");
                    } else {
                        try {
                            System.out.println("Поток 1 получил обе блокировки");
                        } finally {
                            lock2.unlock();
                        }
                    }

                    awaitBarrier();

                } finally {
                    lock1.unlock();
                }

                awaitBarrier();
            }
        });

        Thread thread2 = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {

                lock2.lock();

                try {
                    awaitBarrier();

                    if (!lock1.tryLock()) {
                        System.out.println("Поток 2: lock1 занят, уступаю");
                    } else {
                        try {
                            System.out.println("Поток 2 получил обе блокировки");
                        } finally {
                            lock1.unlock();
                        }
                    }

                    awaitBarrier();

                } finally {
                    lock2.unlock();
                }

                awaitBarrier();
            }
        });

        thread1.start();
        thread2.start();
    }

    private static void awaitBarrier() {
        try {
            barrier.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (BrokenBarrierException e) {
            Thread.currentThread().interrupt();
        }
    }
}