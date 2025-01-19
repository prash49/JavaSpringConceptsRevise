package RunnableAndCallable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Callable {
    public static void main(String[] args) throws Exception {
        int number = 100;

        // create a callable to cal culate the sum
        java.util.concurrent.Callable<Integer> callable = () -> {
            int sum = 0;
            for (int i = 1; i < number; i++) {
                sum += 1;
            }
            return sum;
        };

        // create a thread poo
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        // run with the help of Future
        Future<Integer> future = executorService.submit(callable);


        int result= future.get();
        System.out.println(result);
    }


}
