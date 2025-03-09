package synchronization;

public class SharedResource {
public static synchronized void displayMessage(String message){
    System.out.println("[" + message + "]- start");
    try {
        Thread.sleep(1000);
    }catch (InterruptedException e){
        e.getMessage();
    }
    System.out.println("["+ message+"- - end");
}
}
