package java8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SortedExample {
    public static void main(String[] args) {
        // Here in this i'll be writing sorted method use cases for revision

        //as we know sorted gives back stream it sorts in natural order and custom order
        //1. Natural order: Classes which implemets Comparable directly sorts based on natural order
        // ex: Integers,Double ,String etc
        // if i have a class that implements Comparable interface then it can be also sorts based on natural order
        List<Integer> list = Arrays.asList(25,46,879,52);
        //naturl order sorting
        list.stream().sorted().forEach(System.out::print); // prints naturally sorted Asc
        // i need reverse the sorting order then go For Comparator
        // in comparator there many methods are there for we use Reverse order
        System.out.println();
        list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::print);
        list.stream().sorted(Collections.reverseOrder()).forEach(System.out::print);

        //2.Custom Sorting in sorted
        // this usually combined with Objects Variable ex: Employee list sort based on Salary
        // so first i'll take a Custom compasion by ComparatorBy comparing by int ,double etc.. created separate class
        //for it
        // now here just i want to sort  string list based its length
        List<String> stringList = Arrays.asList("Prashanth", "Navin", "Uday", "Ravi");
        stringList.stream().sorted().forEach(System.out::print);
        // above method sorts based on Alphabetical order because String has implementation for Comparable
        System.out.println("now Sort based on Length ");
        stringList.stream().sorted(Comparator.comparing(String::length)).forEach(System.out::print);

        // calcualte the Average of Integers
        List<Integer> numList = new ArrayList<>(Arrays.asList(1,2,3,4,5,67,8,9,05,9,5));
        numList.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
        Integer sum = numList.stream().collect(Collectors.summingInt(Integer::intValue));
        IntSummaryStatistics intSummary = numList.stream().collect(Collectors.summarizingInt(Integer::intValue));
        List<String> strings = new ArrayList<>(Arrays.asList("prashant", "navin"));
        System.out.println(  strings.stream()
               .map(String::toUpperCase)
               .collect(Collectors.joining(",")));
    }
}
