package lect004;

import lect002.Helpers;

import java.util.LinkedList;
import java.util.concurrent.*;

public class CountDownLatch001 {
    static void main(String[] args) throws InterruptedException, ExecutionException {
        long start = System.nanoTime();
        ExecutorService ex = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        CountDownLatch cdl = new CountDownLatch(50);
        for(int n = 0; n < 50; ++n) {
            int nn = n;
            ex.execute(() -> {
                System.out.println(nn + " " + Helpers.fibon(nn));
                cdl.countDown();
            });
        }

        cdl.await();
        System.out.println("Everything is ready!");

        ex.shutdown();
        ex.awaitTermination(1, TimeUnit.DAYS);
        long end = System.nanoTime();
        System.out.println("Time (pool) " + (end - start) / 1000000000.0);
    }
}
