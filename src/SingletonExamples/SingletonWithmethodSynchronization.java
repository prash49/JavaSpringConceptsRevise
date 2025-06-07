package SingletonExamples;

public class SingletonWithmethodSynchronization {
    private static SingletonWithmethodSynchronization instance;

    private SingletonWithmethodSynchronization() {

    }

    public static synchronized SingletonWithmethodSynchronization getInstance() {
        if (instance == null) {
            instance = new SingletonWithmethodSynchronization();
        }
        return instance;
    }
}
