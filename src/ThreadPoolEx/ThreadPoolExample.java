package ThreadPoolEx;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {
    public static void main(String[] args) {

        // create a Thread pool with an fixed size
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 3; i ++){
            final int taskid = i;
            executorService.submit( () -> {
             try {
                 System.out.println("Task" + taskid +
                         "started ");
                 System.out.println("Task:" + taskid + " executed by" + Thread.currentThread().getName());
             } catch (Exception e){
                 e.printStackTrace();
             }
            });
        }
    }
}
