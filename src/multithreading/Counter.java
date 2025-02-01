package multithreading;

public class Counter {
    private int counter = 0;

    public int getCounter() {
        return counter;
    }

    public synchronized void incrementCounter() {
        counter++;
        // or we can synchronize the block of code
       /* synchronized (this){
            counter++;
        }*/
    }
}
