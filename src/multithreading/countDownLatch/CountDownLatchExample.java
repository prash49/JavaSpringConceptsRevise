package multithreading.countDownLatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
    public static void main(String[] args) {
        int numberOfWorkers = 3;
        CountDownLatch latch = new CountDownLatch(numberOfWorkers);

        Runnable worker = () -> {

            System.out.println("[ worker thread starting  ]"   + Thread.currentThread().getName() );
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                latch.countDown();
            }
        };

        // start the wokring of those thread
        for (int i = 0; i < numberOfWorkers; i++){
            new Thread(worker).start();
        }

        // make main thread to wait till worker thread to finish the task
        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
