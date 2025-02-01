package multithreading;

public class ThreadCommunication {
    public static void main(String[] args) {
// Thread Communication in a shred resources.

        // how two threads are communicating with each other in shared resources.
        // first i need to have producer and consumer classed which implements run and where the logic written
        // the method are synchronized
        //where producer and consumer have shared data , hence the data will passed as argument to create a producer
        //consumer same consumer and producer has run method overridedn and to be passed in thread creation and run
        // using wait and notify they'll communicate
        SharedResource resource = new SharedResource();
        Thread thread1 = new Thread(new Producer(resource));
        Thread thread2 = new Thread(new Consumer(resource));
        thread1.start();
        thread2.start();
    }

}

class SharedResource {
    private int data;
    private boolean hasData;
// data will be produced only when hasdata is false
    public synchronized void produce(int value) {
        while (hasData) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        data = value;
        hasData = true;
        System.out.println("produced:" + value);
        notify();
    }
// when data is not there it'll wait
    // when data consumes it'll make hasdata as false
    public synchronized int consume() {
        while (!hasData) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        hasData = false;
        notify();
        System.out.println("consumed: " + data);
        return data;

    }

}

class Producer implements Runnable {

    private SharedResource sharedResource;

    public Producer(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            sharedResource.produce(i);
        }

    }
}

class Consumer implements Runnable {

    private SharedResource sharedResource;

    public Consumer(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            sharedResource.consume();
        }

    }
}
