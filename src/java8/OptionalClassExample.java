package java8;

import java.util.Optional;

public class OptionalClassExample {
    public static void main(String[] args) {
        Optional<String> nameOptional = Optional.ofNullable("Prashanth");
        String name = nameOptional.get(); // it might throw null pointer exception
        name = nameOptional.orElse("Praveen"); // give default value.
        System.out.println(name);
        name = nameOptional.orElseThrow(); // thow custom exceptions
        Employee employee = new Employee("Prashanth", 250000);
        employee.getName(); // it takes direct value
        // lets modify in getName method to handle for nullPointer we have handled in Get method itself

    }
}
