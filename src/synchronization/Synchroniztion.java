package synchronization;

public class Synchroniztion {
    public static void main(String[] args) {
        // create a counter object
        Counter counter = new Counter();
        //lets create a Runnable task which used for counter and count till 1000
        Runnable run = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
                counter.incrementUsingSynchronized();
            }
        };

        Thread t1 = new Thread(run);
        Thread t2 = new Thread(run);
        try {
            t1.start();
            t2.start();
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);

        }
        System.out.println("counter:" + counter.getCounter());
        System.out.println("sync counter:" + counter.getCounterSync());
    }
}
