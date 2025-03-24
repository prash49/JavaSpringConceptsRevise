package java8;

import java.util.Optional;

public class Employee{
    String name;
    int salary;

    Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public String getName() {
        return Optional.of(name).orElse("DefaultValue");
    }
}
