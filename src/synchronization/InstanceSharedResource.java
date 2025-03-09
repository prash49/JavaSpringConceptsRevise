package synchronization;

public class InstanceSharedResource {
    public synchronized void displayMessage(String message)  {
        System.out.println("[ "+ message +"] -- start");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("[ "+ message +"] -- end");

    }
}
