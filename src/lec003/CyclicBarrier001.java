package lec003;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrier001 {
    static void main() throws InterruptedException {
        Thread[] workers = new Thread[6];

        CyclicBarrier cb = new CyclicBarrier(workers.length);

        for(int i = 0; i < workers.length; ++i) {
            workers[i] = new Thread() {
                @Override
                public void run() {
                    Random random = new Random();
                    try {
                        while(true) {
                            sleep(random.nextInt(2000));
                            System.out.println("Job A finished - " + threadId());

                            cb.await();

                            sleep(random.nextInt(2000));
                            System.out.println("Job B finished - " + threadId());

                            cb.await();
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } catch (BrokenBarrierException e) {
                        throw new RuntimeException(e);
                    }
                }
            };
        }

        for(int i = 0; i < workers.length; ++i)
            workers[i].start();

        for(int i = 0; i < workers.length; ++i)
            workers[i].join();
    }
}
