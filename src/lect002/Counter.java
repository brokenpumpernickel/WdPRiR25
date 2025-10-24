package lect002;

//public class Counter {
//    private int count = 0;
//
//    public int getAndIncrement() {
//        return count++;
//    }
//}

//import java.util.concurrent.locks.ReentrantLock;
//
//public class Counter {
//    private ReentrantLock lock = new ReentrantLock();
//
//    private int count = 0;
//
//    public int getAndIncrement() {
//        lock.lock();
//        int tmp = count++;
//        lock.unlock();
//        return tmp;
//    }
//}

//public class Counter {
//    private int count = 0;
//
//    synchronized public int getAndIncrement() {
//        return count++;
//    }
//}

import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private ReentrantLock lock = new ReentrantLock();

    private int count = 0;

    public int getAndIncrement() {
        lock.lock();
        try {
            return count++;
        } finally {
            lock.unlock();
        }

    }
}