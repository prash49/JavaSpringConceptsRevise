package Atomicity;

public class Atomic {
    public static void main(String[] args) {
        SharedCounter sharedCounter = new SharedCounter();

        new Thread(() -> {
            System.out.println("Threat 1 Started");
            for (int i = 0; i < 50000; i ++){
                sharedCounter.increment();
            }
            System.out.println("Thread 1 stopped");
        }).start();
        new Thread(() -> {
            System.out.println("Threat 2 Started");
            for (int i = 0; i < 50000; i ++){
                sharedCounter.increment();
            }
            System.out.println("Thread 2 Stopped");
        }).start();

        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("final Count:"+ sharedCounter.getCount());
        // as we can observed that count it not in sync, getting race condition

        new Thread(() -> {
            System.out.println("Threat 3 Started");
            for (int i = 0; i < 50000; i ++){
                sharedCounter.incrementAtomic();
            }
            System.out.println("Thread 3 stopped");
        }).start();
        new Thread(() -> {
            System.out.println("Threat 4 Started");
            for (int i = 0; i < 50000; i ++){
                sharedCounter.incrementAtomic();
            }
            System.out.println("Thread 4 Stopped");
        }).start();

        try {
            Thread.sleep(20);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("final Count of AtomicVariables:"+ sharedCounter.getCountOfAtomicInteger());

    }
}
