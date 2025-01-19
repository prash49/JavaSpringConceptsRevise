package CompletableFuture;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureEx {

    public static void main(String[] args) throws InterruptedException{
        // Db task
//        CompletableFuture<String> dbFuture =
//                CompletableFuture.supplyAsync( () -> {fetchDataFromDb();
//                }).thenApply(String::toUpperCase);
    }

   static void fetchDataFromDb(){
        System.out.println("fetch data from db");
    }
}
