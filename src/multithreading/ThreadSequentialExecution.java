package multithreading;

public class ThreadSequentialExecution {
    private static final Object lock = new Object();
    private static  int turn = 1;
    public static void main(String[] args) throws InterruptedException {
        //lets say i need to run thread sequentially

        Thread t1 = new Thread(() -> {
            System.out.println("Thread 1 Executed");
        });
        Thread t2 = new Thread(() -> {
            System.out.println("Thread 1 Executed");
        });
        Thread t3 = new Thread(() -> {
            System.out.println("Thread 1 Executed");
        });
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        t2.start();
        t2.join();
        t3.start();
        t3.join();


        // using Syncronized lock
        Thread t4 = new Thread(() -> {
            synchronized (lock){
            while (turn != 1){
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread 1 is running");
                turn = 2;
                lock.notifyAll();
            }
            }
        });

        Thread t5 = new Thread(() -> {
            synchronized (lock) {
                while (turn != 2) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Thread 2 is running");
                turn = 3;
                lock.notifyAll();   
            }
        });

        t4.start();
        t5.start();

    }
}
