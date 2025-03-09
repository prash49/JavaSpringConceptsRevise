package synchronization;

public class ObjectLevelLock {
    // TODO obejct level locking can be acheived by Adding Synchronization in non static block
    public static void main(String[] args) {
        InstanceSharedResource instanceSharedResource = new InstanceSharedResource();
        InstanceSharedResource instanceSharedResource2 = new InstanceSharedResource();
        Thread t1 = new Thread(()-> instanceSharedResource.displayMessage("Thread 1 started with shared resource"));
        Thread t2 = new Thread(()-> instanceSharedResource.displayMessage("Thread 2 started with shared resource again"));
        Thread t3 = new Thread(()-> instanceSharedResource2.displayMessage("Thread 3 started with shared resource"));
        t1.start();
        t2.start();
        t3.start();
    }
}
