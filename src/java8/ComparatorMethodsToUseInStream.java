package java8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

        /*  Problem 1: Top 3 highest salaried employees
Given: A list of Employee objects
Task: Get names of top 3 highest salaried employees.
        */
        employees.stream().sorted(Comparator.comparingInt(Employee::getSalary).reversed()).limit(3).map(e -> e.getName()).collect(Collectors.toList()).forEach(System.out::print);

        /*Group employees by department and list names
Task: Group by department and return a Map<String, List<String>>
(Department name → List of Employee names)*/
        employees.stream().collect(Collectors.groupingBy(Employee::getSalary, Collectors.mapping(Employee::getName, Collectors.toList())));

        /*Return a Map<String, Long> where key is department and value is employee count*/
        employees.stream().collect(Collectors.groupingBy(Employee::getSalary,Collectors.counting()));
        /*Task: Return a Map<String, Double> of department to average salary.*/
        employees.stream().collect(Collectors.groupingBy(Employee::getSalary, Collectors.averagingInt(Employee::getSalary)));
        /*Task: Return list of duplicate elements (keep only duplicates)*/
        ArrayList<Integer> arrayList = (ArrayList<Integer>) Arrays.asList(1,3,2,4,4,5,1);
        arrayList.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet().stream().filter(e -> e.getValue() > 1).map(e -> e.getKey()).collect(Collectors.toList());
        /* Find the employee with the second highest salary*/
        employees.stream().sorted(Comparator.comparingInt(Employee::getSalary).reversed()).skip(1).findFirst();
        /*join employee names department-wise*/
        employees.stream().collect(Collectors.groupingBy(Employee::getSalary, Collectors.mapping(Employee::getName, Collectors.joining(","))));
/* Partition employees by salary > 50k*/
        employees.stream().collect(Collectors.partitioningBy(e -> e.salary > 50000));
        /*Count character occurrences in a string*/
        String str =  "Prashanth";
        str.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> c != ' ')
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        /* Most frequent element in list of integers*/
        arrayList.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);

        str.chars().mapToObj(c -> (char) c).filter(c -> c != ' ').collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        arrayList.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey).orElse(null);

        /*🔁 1. Get the second lowest salaried employee's name
         */
        employees.stream().min(Comparator.comparing(Employee::getSalary)).map(Employee::getName).orElse("notFound");
        /* Find the department with the highest total salary*/
        employees.stream().collect(Collectors.groupingBy(Employee::getSalary, Collectors.summingInt(Employee::getSalary))).entrySet()
                .stream().max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);
        /* Sort the employees by department name and then by salary descending*/
        employees.stream().sorted(Comparator.comparing(Employee::getName).thenComparingInt(Employee::getSalary).reversed()).collect(Collectors.toList());
        /*🔠 4. Find frequency of characters (excluding spaces) in a String*/
        String s = "hello world";
        s.chars().mapToObj(c -> (char) c).filter(c -> c != ' ').collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        /*🔣 5. Find the first non-repeating character in a string
         */
        String string = "aabbccdee";
        string.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey)
                .findFirst();
        /*Convert a List<Employee> to Map<name, salary>*/
        employees.stream().collect(Collectors.toMap(Employee::getName, Employee::getSalary));
        // TODO Trickey questions
        /*Find all employees whose name starts and ends with the same character (case-insensitive)*/

        employees.stream().filter(e -> {
            String name = e.getName().toLowerCase();
            return name.charAt(0) == name.charAt(name.length() -1 );
        }).collect(Collectors.toList());
                /*💥 8. Remove duplicate Strings from a list ignoring case*/
        List<String> strings = Arrays.asList("Java", "java", "Python", "python");
        strings.stream().map(e -> e.toLowerCase()).distinct().collect(Collectors.toList());
        /*Capitalize first letter of each name in a list*/
        strings.stream().map(name -> name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase())
                .collect(Collectors.toSet());
        //
        Map<Boolean, Long> result = employees.stream()
                .collect(Collectors.partitioningBy(
                        e -> e.getSalary() > 50000,
                        Collectors.counting()
                ));


    }


}

