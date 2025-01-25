package java8.CollectionsHiddenMethods;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectionsHidden {
    public static void main(String[] args) {

        //Collections.frequency
        List<Integer> integerList = Arrays.asList(1,4,5,6,7,8,3,6,7,9);
        // to find out frequency of 7
        long count = Collections.frequency(integerList,7);
        System.out.println("count of 7:"+ count);
        // if need find the frequncy of all
        Map<Integer, Long> map = integerList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        // or
        Map<Integer, Integer> integerLongMap = integerList.stream().collect(Collectors.toMap(num -> num, (num) -> Collections.frequency(integerList, num), (val, val2) -> val ));

        //Collections.disjoint()
        List<Integer> list2 = Arrays.asList(1,7,8,3,6,7);
     boolean areDisjoint =   Collections.disjoint(integerList, list2);
     if(areDisjoint){
         System.out.println("common in lists");
     }

     //Collections.sinlgleton

        //Collections.rotate
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        System.out.println(list);
        Collections.rotate(list, 2); // rotates right , it'll take right 2 elemetns and add those to left start
        System.out.println(list);
        // to rotate left
        Collections.rotate(list, -2);//previously we rotated list to right means i took right two and added into first
        //not left rotate it'll take those 2 and add to back by using -2
        System.out.println(list);
        Collections.rotate(list, list.size()-1);
        System.out.println(list);

        integerList.stream().collect(Collectors.maxBy((o1,o2) -> o1 - o2));
//        integerList.stream().collect(Comparator.comparingInt());


    }
}
