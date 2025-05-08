import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentModificationExceptionExample {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        Thread t1 = new Thread( () -> {

            Iterator<Integer> listIterator = nums.iterator();
            while (listIterator.hasNext()){
                System.out.println("val:"+ listIterator.next());
                nums.add(3);
            }
        });
        Thread t2 = new Thread( () -> {
           nums.add(4);
        });
        t1.start();
        t2.start();
        // above code gives me cocnurrentModification exception hence i'll use
        CopyOnWriteArrayList<Integer> arrayList = new CopyOnWriteArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        Thread t3 = new Thread( () -> {
            Iterator<Integer> iterator = arrayList.iterator();
            while (iterator.hasNext()){
                System.out.println("value:"+ iterator.next());
                arrayList.add(3);
            }
        });
        Thread t4 = new Thread( () -> {
           arrayList.add(4);
        });
        t3.start();
        t4.start();


    }

}
