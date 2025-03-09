package synchronization;

public class ClassLevelLock {

    // TODO Class level lock happens to a Static block of code because its associated with class not to a instance of class
    // hence its called as class level lock
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> SharedResource.displayMessage("Thread 1 from class level locking, class level " +
                "locking happens in static block of code"));
        Thread t2 = new Thread(() -> SharedResource.displayMessage("Thread 2 from class level locking, class level " +
                "locking happens in static block of code"));
        t1.start();
        t2.start();
    }
}
