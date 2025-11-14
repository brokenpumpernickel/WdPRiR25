package lect005;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Conditions {
    public static int counter = 0;
    public static ReentrantLock lock = new ReentrantLock();
    public static Condition condition = lock.newCondition();

    public static class Producer extends Thread {
        @Override
        public void run() {
            while(true) {
                try {
                    lock.lock();
                    ++counter;
                    System.out.println("Produced: " + counter);
                    condition.signalAll();
                } finally {
                    lock.unlock();
                }

                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static class Consumer extends Thread {
        private int lastCounter = -1;

        @Override
        public void run() {
            while(true) {
                try {
                    lock.lock();
                    while(lastCounter == counter)
                        condition.awaitUninterruptibly();
                    lastCounter = counter;
                    System.out.println("Consumed " + lastCounter + " by " + threadId());
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    static void main() throws InterruptedException {
        Producer producer = new Producer();
        producer.start();

        Consumer[] consumers = new Consumer[5];
        for(int i = 0; i < consumers.length; ++i) {
            consumers[i] = new Consumer();
            consumers[i].start();
        }

        producer.join();
    }
}
