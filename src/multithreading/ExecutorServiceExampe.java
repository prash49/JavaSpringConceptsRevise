package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public  class ExecutorServiceExampe {
    public static void main(String[] args) {
        ExecutorService executorServices = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 5; i++){
            executorServices.submit(new Task("Task "+ i));
        }
        executorServices.shutdown();
    }

    
}
