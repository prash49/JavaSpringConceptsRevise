package VisibilityInMultiThread;

public class VolatimeKeyWord {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        new Thread(() -> {
            System.out.println("Thread 1 started");

            try {
                System.out.println("T1 Logic strted");
                Thread.sleep(1000);
                System.out.println("t1 logic completed");
                sharedResource.setFlag(true);
                System.out.println("t1 flag set");

            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            System.out.println("Thread 2 started");
            while (!sharedResource.getFlag()){
                //
            }
            System.out.println("Thread 2 completed");
        }).start();
    }
}
