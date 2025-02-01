package multithreading;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter(); // shred resource
       MyThreadCounter myThreadCounter = new MyThreadCounter(counter);
       MyThreadCounter myThreadCounte2 = new MyThreadCounter(counter); // second thread accessing shared resource.
       myThreadCounter.start();
       myThreadCounte2.start();
       myThreadCounter.join();
       myThreadCounte2.join();
        System.out.println("count:"+ counter.getCounter());

    }
}
