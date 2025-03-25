package java8;

import LogicBuildingPrograms.Fibonacci;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8Problems {
    public static void main(String[] args) {
        //  32) Find the age of a person in years if the birthday has given?
        LocalDate localDate = LocalDate.of(1997, 02, 23);
        LocalDate now = LocalDate.now();
        System.out.println("Age :" + ChronoUnit.YEARS.between(localDate, now));

//        31) How do you get last element of an array?
        List<String> listOfStrings = Arrays.asList("One", "Two", "Three", "Four", "Five", "Six");
        // use skip till n -1
        System.out.println("last:" + listOfStrings.stream().skip(listOfStrings.size() - 1).findFirst().get());
        //30) First 10 odd numbers
//        Stream.iterate(new int[] {1,3} ,f-> new int[]  {f[1]}, f[1] + 2 })
//        29) Fibonacci series
        Stream.iterate(new int[]{0, 1}, f -> new int[]{f[1], f[0] + f[1]}).
                limit(10)
                .map(f -> f[0])
                .forEach(i -> System.out.print(i + " "));

        //    28) Find first non-repeated character in a string?
        String inputString = "Java Concept Of The Day";

        String intermediateString = inputString.replaceAll("\\s+", "").toLowerCase();
        Arrays.stream(intermediateString.split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())).entrySet()
                .stream().filter(stringLongEntry -> stringLongEntry.getValue() == 1)
                .map(entry -> entry.getValue())
                .findFirst()
                .get();
        //to conver string to stream and find repeated
        inputString.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(entry -> entry.getValue())
                .findFirst()
                .get();

        //24) Given a list of strings, find out those strings which start with a number?
        List<String> listOfString = Arrays.asList("One", "2wo", "3hree", "Four", "5ive", "Six");
        listOfString.stream().filter(str -> Character.isDigit(str.charAt(0))).forEach(System.out::print);
        //18) Reverse each word of a string using Java 8 streams?
        String str = "Java Concept Of The Day";

        String reversedStr = Arrays.stream(str.split(" "))
                .map(word -> new StringBuffer(word).reverse())
                .collect(Collectors.joining(" "));

//        17) How do you find common elements between two arrays?
        List<Integer> list1 = Arrays.asList(71, 21, 34, 89, 56, 28);

        List<Integer> list2 = Arrays.asList(12, 56, 17, 21, 94, 34);
        list1.stream().filter(list2::contains).collect(Collectors.toList());
        //15) Given a list of strings, sort them according to increasing order of their length?x
        List<String> strings = Arrays.asList("Java", "Python", "C#", "HTML", "Kotlin", "C++", "COBOL", "C");
        strings.stream().sorted(Comparator.comparing(String::length));
        //14) Find second largest number in an integer array?

        List<Integer> listOfIntegers = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
        listOfIntegers.stream().sorted(Comparator.reverseOrder()).skip(1);

        String string = "the quick brown fox jumps over the lazy dog the fox is quick";
        String[] split = string.split("\\s+");
        Map<String, Long> mapValues = Arrays.asList(split).stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        for (Map.Entry<String, Long> entry : mapValues.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        List<List<Integer>> nestedLists = Arrays.asList(
                Arrays.asList(3, 5, 2),
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5));

        List<Integer> flat = nestedLists.stream().flatMap(List::stream).collect(Collectors.toList());
        flat.stream().forEach(System.out::print);

        List<String> list = Arrays.asList("apple", "banana", "apple","orange");
        String reducedString = list.stream().distinct().reduce("", (s1, s2) -> s1 + " " + s2);
        System.out.println("reducedString :: {}"+ reducedString);

        List<Institute> instituteList = new ArrayList<>();

        instituteList.add(new Institute("IIM", Arrays.asList("Bangalore", "Ahmedabad", "Kozhikode", "Lucknow")));
        instituteList.add(new Institute("IIT", Arrays.asList("Delhi", "Mumbai", "Kharagpur")));
        instituteList.add(new Institute("NIFT", Arrays.asList("Hyderabad", "Mumbai", "Patna", "Bangalore")));

        //Java 8 Map() : Get names of all institutes

        List<String> namesOfInstitutes = instituteList.stream().map(Institute::getName).collect(Collectors.toList());

        System.out.println(namesOfInstitutes);

        //Java 8 FlatMap() : Get unique locations of all institutes

        // flat map takes Stream<Stream<T>> tranforms to Stream<T>
        Set<String> locationsOfInstitutes = instituteList.stream().flatMap(institute -> institute.getLocations().stream()).collect(Collectors.toSet());

        System.out.println(locationsOfInstitutes);
        System.out.println("boolean: "+ Stream.of(123,56,7,8).allMatch(n -> n == 123));
        System.out.println("boolean: "+ Stream.of(123,56,7,8).anyMatch(n -> n == 123));

        List<List<String>> names = List.of(
                List.of("Alice", "Bob"),
                List.of("Charlie", "David"),
                List.of("Eve", "Frank")
        );

        names.stream()
                .flatMap(Collection::stream)
                .forEach(System.out::println);

        Stream<String> words = Stream.of("hello", "world");
        words.flatMap(word -> Stream.of(word.split("")))
                .forEach(System.out::println);

        List<String> list11 = List.of("apple", "banana");
        List<String> list12 = List.of("cherry", "date");

        Stream<List<String>> lists = Stream.of(list11, list12);
        lists.flatMap(List::stream)
                .forEach(System.out::println);
    }


}
