package java8;

import java.util.List;
import java.util.stream.Stream;

public class LazyLoadingExample {
    public static void main(String[] args) {
        List<String> names = List.of("Prashanth", "Praveen", "Navin", "uday");
        Stream<String> stream = names.stream()
            .filter(name -> {
                System.out.println("Filtering: " + name);
                return name.startsWith("P") || name.startsWith("U");
            })
            .map(name -> {
                System.out.println("Mapping: " + name);
                return name.toUpperCase();
            });
        System.out.println("Stream defined, but no execution yet!");
        // Execution starts only when terminal operation is called
        stream.forEach(System.out::println);
    }
}