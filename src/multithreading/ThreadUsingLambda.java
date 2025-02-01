package multithreading;

public class ThreadUsingLambda {
    public static void main(String[] args) {
        //creating thread using Lambda expression

        Thread t1  = new Thread(() -> System.out.println("new thread"+ Thread.currentThread().getName()), "threaddd");

        Runnable task = () -> {System.out.println("new runnable task"); };
        Thread thread = new Thread(task);
    }
}
