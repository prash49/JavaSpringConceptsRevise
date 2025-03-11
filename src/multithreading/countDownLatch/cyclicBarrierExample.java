package multithreading.countDownLatch;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class cyclicBarrierExample {
    public static void main(String[] args) {
        int numberOfThreadsToWork = 3;
        //cyclic barrier takes 2 params one barrier count and barrier runnable action//or just barrier count
        CyclicBarrier barrier =  new CyclicBarrier(numberOfThreadsToWork, ( ) -> System.out.println("Barrrier action"));

        Runnable runnable =  () -> {
            System.out.println("Barrier started");
            try {
                barrier.await();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        };

        for (int i = 0; i < numberOfThreadsToWork; i++){
            new Thread(runnable).start();
        }
    }
}
