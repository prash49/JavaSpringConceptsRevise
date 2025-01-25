package CompletableFuture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class Executors {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = java.util.concurrent.Executors.newFixedThreadPool(10);
        Future<List<Integer>> future = executorService.submit( () -> {
            System.out.println("Thread:"+ Thread.currentThread().getName());
            return Arrays.asList(1,2,3,4);
        });

        List<Integer> integerList = future.get();
        System.out.println(integerList.size());
        // if i have a long running task and i need run that asynchronously and that result need to provide for another thread its not possible in
        //Future
    }

}
