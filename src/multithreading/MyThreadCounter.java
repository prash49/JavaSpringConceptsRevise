package multithreading;

public class MyThreadCounter extends Thread {
    private Counter counter;

    MyThreadCounter(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.incrementCounter();
        }
    }
}
