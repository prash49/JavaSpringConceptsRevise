package multithreading;

public class Demo {
    public static void main(String[] args) {
// creating a thread by extending Threading in another class
        World world =  new World();
        // as we already extended thread we can start thread by .start()
        world.start();
        // creating thread by implementing runnable interface
        //if i implement i need to pass that in thread object to start
        RunnableWorld runnableWorld = new RunnableWorld();
        Thread thread = new Thread(runnableWorld);
        thread.start();

    }
}
