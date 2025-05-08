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
        Map<String, Double> averageEmpList = employees.stream()
                .collect(Collectors.groupingBy(Employee::getName, Collectors.averagingInt(Employee::getSalary)));
        // write a Stream to collect max salary by name
        Map<String, Optional<Employee>> maxSalByName = employees.stream()
                .collect(Collectors.groupingBy(Employee::getName, Collectors.maxBy(Comparator.comparing(Employee::getSalary))));

        // in groupping by it requires function so you got with Employee::getName getName is function
        // another parameter it can take is Collector hence i need to provide Collector
        //here i need to define on what basis it needs to collect i need to collect based on Max, min ,couting, averaging , summingint

        /*Advanced follow-up: Modify it to get just the Employee name, not the Optional<Employee>:*/
        employees.stream()
                .collect(Collectors.groupingBy(Employee::getName,
                        Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Employee::getSalary)), optionalEmployee -> optionalEmployee.map(Employee::getName).orElse(""))));

        // how you'll debug in streams
        /* todo : Peek is used to debug*/
        employees.stream()
                .filter(e -> e.getName().startsWith("P"))
                .peek(p -> System.out.println("peeked:"+p)) // peek take consumer which takes ininput and utlizies using accept
                .collect(Collectors.toList());

        // How to use Flatmap
        /*
        * ex: we have list of orders in each order it can have multiple products i need to get all products in all orders
        * todo then i'll use flatMap
        * how i'll use :  flatMap()inside this i'll get product the list of orders i need to flatten it
        * flatMap( product -> product.getOrders.stream())
        * now i need to use map to transform that stream to string hence i wrote on method
        *     .map(OrderItem::getProductName) then collect distinct
        *
         * */


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
