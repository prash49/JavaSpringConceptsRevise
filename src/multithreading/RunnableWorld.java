package multithreading;

public class RunnableWorld implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++){
            System.out.println("Welcome");
        }
    }
}
