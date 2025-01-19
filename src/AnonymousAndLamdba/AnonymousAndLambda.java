package AnonymousAndLamdba;

public class AnonymousAndLambda {
    public static void main(String[] args) {

        // Anonymous
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            System.out.println("runnable overidden");
        }
    };
    runnable.run();

    // lambda
        //invoke  dynamic instruction is added to the class
        Runnable runnable1 = () -> {
            System.out.println("implementing runnable using Lambda expression");
        };
        runnable1.run();

    }
}
