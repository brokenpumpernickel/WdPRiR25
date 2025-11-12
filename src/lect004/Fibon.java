package lect004;

import lect002.Helpers;

import java.util.LinkedList;
import java.util.concurrent.*;

public class Fibon {
    static void main(String[] args) throws InterruptedException, ExecutionException {
        long start = 0;
        long end = 0;

//        start = System.nanoTime();
//        for(int n = 0; n < 50; ++n)
//            System.out.println(n + " " + Helpers.fibon(n));
//        end = System.nanoTime();
//        System.out.println("Time (sequential) " + (end - start) / 1000000000.0);

//        start = System.nanoTime();
//        ExecutorService ex = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
//        for(int n = 0; n < 50; ++n) {
//            int nn = n;
//            ex.execute(() -> System.out.println(nn + " " + Helpers.fibon(nn)));
//        }
//        ex.shutdown();
//        ex.awaitTermination(1, TimeUnit.DAYS);
//        end = System.nanoTime();
//        System.out.println("Time (pool) " + (end - start) / 1000000000.0);

//        start = System.nanoTime();
//        ExecutorService ex = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
//        LinkedList<Future<String>> results = new LinkedList<>();
//        for(int n = 0; n < 50; ++n) {
//            int nn = n;
//            results.add(ex.submit(() -> nn + " " + Helpers.fibon(nn)));
//        }
//        for(var future : results)
//            System.out.println(future.get());
//        ex.shutdown();
//        ex.awaitTermination(1, TimeUnit.DAYS);
//        end = System.nanoTime();
//        System.out.println("Time (pool) " + (end - start) / 1000000000.0);

        start = System.nanoTime();
        ExecutorService ex = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        CompletionService<String> cs = new ExecutorCompletionService<>(ex);
        for(int n = 49; n >= 0; --n) {
            int nn = n;
            cs.submit(() -> nn + " " + Helpers.fibon(nn));
        }
        for(int i = 0; i < 50; ++i)
            System.out.println(cs.take().get());
        ex.shutdown();
        ex.awaitTermination(1, TimeUnit.DAYS);
        end = System.nanoTime();
        System.out.println("Time (pool) " + (end - start) / 1000000000.0);
    }
}
