package java8;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Java8StreamTricky {
    public static void main(String[] args) {
        List<Employee> employees = getEmployees(); // Assume this returns thousands of employees
        Optional<Employee> highestPaid = employees.stream()
                .filter(e -> e.getName().startsWith("P"))
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .findFirst();

        //Find the performance issue from above?
        // here the Performance issue is we parallelly filtering and sorting each element later
        /*todo to increase the performance we do like below
           This avoids sorting the entire stream when we only need the maximum value.
         *  */
        employees.stream()
                .filter(e -> e.getName().startsWith("P"))
                .max(Comparator.comparing(Employee::getSalary).reversed());

        //print out put using parallel stream
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> result = numbers.parallelStream()
                .filter(n -> n % 2 == 0)
                .sorted()
                .collect(Collectors.toList());
        System.out.println(result);
        // as we are using sorted it'll keep the correct order
        System.out.println("without sort");
        List<Integer> result2 = numbers.parallelStream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(result2);

        // Write a Stream to collect names with avg salary
        employees.stream()
                .collect(Collectors.groupingBy(Employee::getName, Collectors.averagingInt(Employee::getSalary)));
        // write a Stream to collect max salary by name
        employees.stream()
                .collect(Collectors.groupingBy(Employee::getName, Collectors.maxBy(Comparator.comparing(Employee::getSalary))));

        // in groupping by it requires function so you got with Employee::getName getName is function
        // another parameter it can take is Collector hence i need to provide Collector
        //here i need to define on what basis it needs to collect i need to collect based on Max, min ,couting, averaging , summingint
    }
   public static List<Employee> getEmployees(){
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Prashanth", 35000));
        employees.add(new Employee("Navon", 25000));
        employees.add(new Employee("Praveen", 12000));
        employees.add(new Employee("naveen", 5000));
        return  employees;

    }
}
