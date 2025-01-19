package Atomicity;

import java.util.concurrent.atomic.AtomicInteger;

public class SharedCounter {
    private int count;

    void increment() {
        count++;
    }

    int getCount() {
        return count;
    }
    // due to visibility problem leading to race condition we use atomic variables

    private AtomicInteger atomicInteger = new AtomicInteger(0);
     void incrementAtomic(){
         atomicInteger.getAndIncrement();
     }

     AtomicInteger getCountOfAtomicInteger(){
         return atomicInteger;
     }
}
