package SingletonExamples;

public class SingletonWithSynchronizationVolatile {
    private static volatile SingletonWithSynchronizationVolatile instance;
    private SingletonWithSynchronizationVolatile(){

    }
    public static SingletonWithSynchronizationVolatile getInstance(){
        if (instance ==null){
            synchronized (SingletonWithSynchronizationVolatile.class){
                if (instance == null){
                    instance = new SingletonWithSynchronizationVolatile();
                }
            }
        }
        return instance;
    }
}
