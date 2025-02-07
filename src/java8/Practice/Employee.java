package java8.Practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
    }
}