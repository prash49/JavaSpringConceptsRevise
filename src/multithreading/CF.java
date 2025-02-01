package multithreading;

import java.util.concurrent.CompletableFuture;

public class CF {
    public static void main(String[] args) {
        CompletableFuture completableFuture =  CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(100);
                System.out.println("woker thread");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Ok";
        });
    }
}
