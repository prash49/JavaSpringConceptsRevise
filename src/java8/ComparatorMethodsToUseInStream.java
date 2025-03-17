package java8;

import java.util.*;
import java.util.stream.Collectors;

public class ComparatorMethodsToUseInStream {
    //in this i'll look into comparator methods which are used for Sorting all kids
    //ex: natural order, Objects,Map etc..
    public static void main(String[] args) {
        //Comparator is functional interface that provides methods to define custom ordering
// i understood i need to provide some custom implementation or to override the Comparable i use this
        //ex: stringList usually sorts based on alphabetical i need to override to provide the implementation based
        //on Length
        List<String> stringList = Arrays.asList("ABCD", "Prashanth", "N");
        stringList.stream().sorted(Comparator.comparingInt(String::length)).forEach(System.out::print);
        stringList.stream().sorted(Comparator.comparing(String::length)).forEach(System.out::print);
        // above methods behave the same because length return int
        // now i need to rever the order
        System.out.println();
        stringList.stream().sorted(Comparator.comparing(String::length).reversed()).forEach(System.out::print);
        stringList.stream().sorted(Comparator.comparing(String::length).reversed()).forEach(System.out::print);
        System.out.println();
        stringList.stream().sorted(Comparator.comparing(String::length, Comparator.reverseOrder())).forEach(System.out::print);
        // i can chain multiple Comparings
        System.out.println();
        stringList.stream().sorted(Comparator.comparing(String::length).thenComparingInt(String::length)).forEach(System.out::print);

        // this can usefull when i need to add comparsion based on multiple fields

        List<Employee> employees = Arrays.asList(
                new Employee("Prashanth", 50000),
                new Employee("Navin", 70000),
                new Employee("Uday", 60000)
        );
        // now i'll sort by name

        employees.stream().sorted(Comparator.comparing(employee -> employee.name)).forEach(e -> System.out.println("name" + e.name));
        // i need to sort by salary
        employees.stream().sorted(Comparator.comparing(employee -> employee.salary, Comparator.reverseOrder())).forEach(e -> System.out.println("salary" + e.name));
        employees.stream().sorted(Comparator.comparing(Employee::getName).reversed()).forEach(e -> System.out.println("salry" + e.name));

        // comparing with multiple
        employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary)
                        .thenComparing(Employee::getName))
                .collect(Collectors.toList());


        // lets see hows the behaviour in MAP
        Map<String, Integer> map = new HashMap<>();
        map.put("John", 25);
        map.put("Alice", 30);
        map.put("Bob", 20);
        // i need to sort it based on keys
        // in map we make use of Map.Entry.comparingByKey and ComparingByValue
        map.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1,e2) -> e1,LinkedHashMap::new));


        map.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1,e2) -> e1, LinkedHashMap::new));

        // find sum of Values in Map
        int sum = map.entrySet().stream().mapToInt(e -> e.getValue()).sum();
        System.out.println("sum"+ sum);
      int sum2 =  map.values().stream().mapToInt(Integer::intValue).sum();
        System.out.println("sum 2 :"+sum2);
    }


}

