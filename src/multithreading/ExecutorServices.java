package multithreading;

import java.util.concurrent.*;

public class ExecutorServices {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        executor.submit(() ->{
           for (int i =0; i < 10; i ++){
               System.out.println(i);
           }
        });
        executor.shutdown();
        // executors returns Future

       /* ExecutorService executor2 = Executors.newFixedThreadPool(10);
        Future<Integer> future = executor2.submit(() -> 42);
        executor2.awaitTermination(100, TimeUnit.SECONDS);
        System.out.println("futute"+ future.get());
        executor2.shutdown();*/
// above code won't work because runnable won't return anything
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Callable callable = () -> 42;
        Future<Integer> future =  executorService.submit(callable);
        System.out.println("furure"+ future.get());
        executorService.shutdown();

    }
}
