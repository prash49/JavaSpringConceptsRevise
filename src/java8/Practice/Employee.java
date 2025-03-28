package java8.Practice;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Employee {
    int id;

    String name;

    int age;

    String gender;

    String department;

    int yearOfJoining;

    double salary;

    public Employee(int id, String name, int age, String gender, String department, int yearOfJoining, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.yearOfJoining = yearOfJoining;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getDepartment() {
        return department;
    }

    public int getYearOfJoining() {
        return yearOfJoining;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Id : " + id
                + ", Name : " + name
                + ", age : " + age
                + ", Gender : " + gender
                + ", Department : " + department
                + ", Year Of Joining : " + yearOfJoining
                + ", Salary : " + salary;
    }

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Prashanth", 27, "male", "Backend", 2022, 25000));
        employees.add(new Employee(1, "Sanjana", 24, "female", "Frontend", 2023, 10000));
        employees.add(new Employee(1, "Lakshmi", 35, "female", "lead", 2020, 50000));
        employees.add(new Employee(1, "Rashmi", 26, "male", "Backend", 2021, 40000));
//        54) Given a list of employees, write a Java 8 code to count the number of employees in each department?
        employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
//        55) Given a list of employees, find out the average salary of male and female employees?
        employees.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
//        56) Write a Java 8 code to get the details of highest paid employee in the organization from the given list of employees?
        employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).findFirst();
        //or
        employees.stream().collect((Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));
        //57) Write the Java 8 code to get the average age of each department in an organization?
        employees.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getAge)));
        //58) Given a list of employees, how do you find out who is the senior most employee in the organization?
        employees.stream().sorted(Comparator.comparingInt(Employee::getYearOfJoining).reversed()).findFirst();
        // 59) Given a list of employees, get the details of the most youngest employee in the organization?
        employees.stream().min(Comparator.comparingInt(Employee::getAge));
        //60) How do you get the number of employees in each department if you have given a list of employees?
        employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        //61) Given a list of employees, find out the number of male and female employees in the organization?
        employees.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

        // Example of flatmap
        // employees.stream().flatMap( i -> i.getLocations().stream()).collect.

        List<String> listOfStrings = Arrays.asList("Facebook", "Twitter", "YouTube", "WhatsApp", "LinkedIn");
        //6) Given a list of strings, join the strings with ‘[‘ as prefix, ‘]’ as suffix and ‘,’ as delimiter?
        listOfStrings.stream().collect(Collectors.joining(",", "[", "]"));
        List<Integer> listOfIntegers = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
//7) From the given list of integers, print the numbers which are multiples of 5?
        listOfIntegers.stream().filter(i -> i % 5 == 0).forEach(System.out::println);
        listOfIntegers.stream().min(Comparator.naturalOrder()).get();
        listOfIntegers.stream().max(Comparator.naturalOrder()).get();
        int[] a = new int[]{4, 2, 7, 1};

        int[] b = new int[]{8, 3, 9, 5};
        //9) How do you merge two unsorted arrays into single sorted array using Java 8 streams?
        int[] c = IntStream.concat(Arrays.stream(a), Arrays.stream(b)).toArray();
        // distince
        int[] d = IntStream.concat(Arrays.stream(a), Arrays.stream(b)).distinct().toArray();

        List<Integer> intList = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
        intList.stream().sorted().limit(3);
        String s1 = "RaceCar";
        String s2 = "CarRace";

        s1 = Stream.of(s1.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());

        s2 = Stream.of(s2.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());

        if (s1.equals(s2)) {
            System.out.println("Two strings are anagrams");
        }

        LinkedHashMap<String, Employee> employeeMap = employees.stream().collect(Collectors.toMap(e -> e.getName(), e -> e, (e1, e2) -> e1, LinkedHashMap::new));

        System.out.println("to Map");
        for (Map.Entry entry : employeeMap.entrySet()) {
            System.out.println("key" + entry.getKey() + " " + entry.getValue());
        }


        //Write a java 8 program to take input as a list of Employee and return a Map of Employee and List of Employee grouped by department?
        Map<String, List<Employee>> employeeDepartmentGroup = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
       /* for (Map.Entry entry : employeeDepartmentGroup.entrySet()) {
           entry.getKey() + entry.getValue()
        }*/

        employeeDepartmentGroup.forEach((department, empList) -> {
            System.out.println(department + ": " + empList);
        });

        Map<String, Optional<Employee>> secondMaxSalaryByDepartment = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.mapping(
                                e -> e,
                                Collectors.toList()
                        )
                ))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> {
                            List<Employee> empList = entry.getValue();
                            return empList.stream()
                                    .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                                    .distinct()
                                    .skip(1) // Skip the first max salary
                                    .findFirst(); // Take the second max salary
                        }
                ));

        // Printing the result
        secondMaxSalaryByDepartment.forEach((department, emp) -> {
            System.out.println(department + ": " + emp.orElse(null));
        });
    }
}