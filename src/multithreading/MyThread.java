package multithreading;

public class MyThread extends  Thread{

    public MyThread(String name){
        super(name);
    }
    @Override
    public void run() {
        System.out.println("Print in thread");
        Thread.yield(); // gives the time for other threads to access
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread("Thread name");
        MyThread myThread2 = new MyThread("Thread name");
        MyThread myThread3 = new MyThread("Thread name");
//        myThread.join(); // --> wait untill the thread execution over.
        myThread.setPriority(Thread.MAX_PRIORITY);
        myThread2.setPriority(Thread.MIN_PRIORITY);
        myThread3.setPriority(Thread.NORM_PRIORITY);
        myThread.start();
        myThread2.start();
        myThread3.start();



    }
}
