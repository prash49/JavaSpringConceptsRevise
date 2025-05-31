package java8;

import java.util.Optional;

public class OptionalClassExample {
    public static void main(String[] args) {
        Optional<String> nameOptional = Optional.ofNullable("Prashanth");
        String name = nameOptional.get(); // it might throw null pointer exception
        name = nameOptional.orElse("Praveen"); // give default value.
        nameOptional.ifPresentOrElse( str -> {
            System.out.println("name"+ str);
        }, () -> {
            System.out.println("name not present");
        });
        System.out.println(name);
        name = nameOptional.orElseThrow(); // thow custom exceptions
        Employee employee = new Employee("Prashanth", 250000);
        employee.getName(); // it takes direct value
        // lets modify in getName method to handle for nullPointer we have handled in Get method itself

        /* 1. Creating optional with non null value*/
        Optional<String> nameOpt = Optional.of("Prashanth");
        System.out.println(nameOpt.get());

        /*2. Creating optional of Empty */
        Optional<String> emptyOptional = Optional.empty();
        // if use emptyOptional.get() gives us no such value present

        /* 3. Optional of nullable*/
        Optional<String> offNullableVal = Optional.ofNullable(null);
        System.out.println("it'll pring empty: see"+ offNullableVal.get());
        offNullableVal = Optional.ofNullable("Prashanth");
        System.out.println("val:"+ offNullableVal.get());

        /*4. check if Optional has value*/
        Optional<String> optionalName = Optional.ofNullable("Prashanth");
        System.out.println(optionalName.isPresent());
        /*5. else */
        Optional<String> defaultVal = Optional.ofNullable("Prasha");
                defaultVal.orElse("Navin");

                /*6. Throw exception*/
        defaultVal.orElseThrow();

        /* Fiter*/
       Optional<String> filtered =  defaultVal.filter(s -> s.startsWith("P"));
       filtered.map(Object::toString);

       /*Chaining*/
        Optional<String> myName  = Optional.of("Prashanth")
                .map(s -> s.concat(" N"))
                .filter(s -> s.contains("N"))
                .orElse("My name is Prash").describeConstable();
    }
}
