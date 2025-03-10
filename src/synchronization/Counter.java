package synchronization;

public class Counter {
    private int counter;
    private int counter2;

    public void increment() {
        counter++;
    }

    public void incrementUsingSynchronized() {
        synchronized (Counter.class) {
            counter2++;
        }
    }

    public int getCounter() {
        return counter;
    }
    public int getCounterSync() {
        return counter2;
    }

}
