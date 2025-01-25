package CompletableFuture;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureEx {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // Db task
//        CompletableFuture<String> dbFuture =
//                CompletableFuture.supplyAsync( () -> {fetchDataFromDb();
//                }).thenApply(String::toUpperCase);
      CompletableFuture<Void>  completableFuture =  CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
           // some task to run
                // and can throw some error
            }
        });
        completableFuture.get();

        // we can use executors with CompletableFuture
        ExecutorService executorService = Executors.newFixedThreadPool(6);
        CompletableFuture<Void> completableFuture1 =  CompletableFuture.runAsync( () -> {
            try {

            }catch (Exception e){
                e.printStackTrace();
            }
        }, executorService);
        completableFuture1.get();

        //Supply async

    }
    static void fetchDataFromDb() {
        System.out.println("fetch data from db");
    }

    String suplyAsync() throws ExecutionException, InterruptedException {
        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> {
            return String.valueOf(Arrays.asList("Prashanth", "Navin"));
        });
        return  stringCompletableFuture.get();

    }

}
