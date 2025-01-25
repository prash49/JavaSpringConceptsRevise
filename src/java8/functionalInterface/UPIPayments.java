package java8.functionalInterface;

import java.util.Date;
import java.util.Random;

@FunctionalInterface
public interface UPIPayments {

    String doPayments(Long amount, String cardDetailsJson);
    // above method is a Abstract method where we need to provide implemention by implemeted class

    //i can define a Default and statis methods n number
    // static methods are used as utility class,

    default double getRandomDouble(){
        return new Random().nextDouble();
    }
     static Date getDate(){
        return  new Date();
     }
}

