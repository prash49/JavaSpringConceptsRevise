package Diamond;

public class DeadLock {
    private static final Object account =  new Object();
    private static final Object transaction =  new Object();

    public static void main(String[] args) {
        Thread debitCard = new Thread( () -> {
            synchronized (account){
                System.out.println("Thread DebitCard: Holding account object");

                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            System.out.println("Thread DebitCard: before Holding transaction object");
            synchronized (transaction){
                System.out.println("Thread DebitCard: Holding Transaction object");
            }
        });

        debitCard.setName("Debit card Thread");

        Thread onlinePayment = new Thread( () -> {
           synchronized (transaction) {
               System.out.println("Thread onlinePayment: Holding Transaction Object");
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               System.out.println("Thread onlinePayment:before  Holding Account Object");
               synchronized (account){
                   System.out.println("Thread onlinePayment:  Holding Account Object");
               }
           }
        });

        onlinePayment.setName("Online Payment Thread");

        debitCard.start();
        onlinePayment.start();

        // To detect dead lock
        while (true){
            if(debitCard.getState() == Thread.State.BLOCKED &&
            onlinePayment.getState() == Thread.State.BLOCKED){
                System.out.println("DeadLocked threads:" + debitCard.getName() + " " + onlinePayment.getName());
                break;
            }

        }
    }

}
