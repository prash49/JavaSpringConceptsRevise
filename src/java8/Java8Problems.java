package java8;

import LogicBuildingPrograms.Fibonacci;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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

        List<String> list = Arrays.asList("apple", "banana", "apple", "orange");
        String reducedString = list.stream().distinct().reduce("", (s1, s2) -> s1 + " " + s2);
        System.out.println("reducedString :: {}" + reducedString);

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
        System.out.println("boolean: " + Stream.of(123, 56, 7, 8).allMatch(n -> n == 123));
        System.out.println("boolean: " + Stream.of(123, 56, 7, 8).anyMatch(n -> n == 123));

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

        System.out.println("-----------------------------------------------------");
        // Convert a List into a Map where key and Value are number itself
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        Map<Integer, Integer> intMap = integers.stream().collect(Collectors.toMap(Function.identity(), Function.identity()));
        Map<Integer, Integer> intMap2 = integers.stream().collect(Collectors.toMap(Function.identity(), Function.identity(), (e1, e2) -> e1, LinkedHashMap::new));
        intMap.keySet().forEach(System.out::println);
        System.out.println("=======================");
        intMap.values().forEach(System.out::print);
        System.out.println("------------------------------");
        int sum = integers.stream().mapToInt(e -> e).sum();
        System.out.println("sum :" + sum);
        Arrays.asList(1, 2, 3).stream().filter(n -> n > 2).forEach(System.out::print);

        List<Employee> employees = Arrays.asList(
                new Employee("Prashanth", 50000),
                new Employee("Navin", 70000),
                new Employee("Uday", 60000)
        );
        // Revising
//         Problem 1: Top 3 highest salaried employees
//         Given: A list of Employee objects
//         Task: Get names of top 3 highest salaried employees.

        employees.stream().sorted(Comparator.comparingInt(Employee::getSalary).reversed()).limit(3).map(e -> e.getName()).collect(Collectors.toList()).forEach(System.out::print);

        /*Group employees by department and list names
Task: Group by department and return a Map<String, List<String>>
(Department name → List of Employee names)*/
        employees.stream().collect(Collectors.groupingBy(Employee::getSalary, Collectors.mapping(Employee::getName, Collectors.toList())));

        /*Return a Map<String, Long> where key is department and value is employee count*/
        employees.stream().collect(Collectors.groupingBy(Employee::getSalary, Collectors.counting()));
        /*Task: Return a Map<String, Double> of department to average salary.*/
        employees.stream().collect(Collectors.groupingBy(Employee::getSalary, Collectors.averagingInt(Employee::getSalary)));
        /*Task: Return list of duplicate elements (keep only duplicates)*/
        ArrayList<Integer> arrayList = (ArrayList<Integer>) Arrays.asList(1, 3, 2, 4, 4, 5, 1);
        arrayList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().filter(e -> e.getValue() > 1).map(e -> e.getKey()).collect(Collectors.toList());
        /* Find the employee with the second highest salary*/
        employees.stream().sorted(Comparator.comparingInt(Employee::getSalary).reversed()).skip(1).findFirst();
        /*join employee names department-wise*/
        employees.stream().collect(Collectors.groupingBy(Employee::getSalary, Collectors.mapping(Employee::getName, Collectors.joining(","))));
        /* Partition employees by salary > 50k*/
        employees.stream().collect(Collectors.partitioningBy(e -> e.salary > 50000));
        /*Count character occurrences in a string*/
        String str1 = "Prashanth";
        str1.chars()
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

        str1.chars().mapToObj(c -> (char) c).filter(c -> c != ' ').collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        arrayList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
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
        s.chars().mapToObj(c -> (char) c).filter(c -> c != ' ').collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        /*🔣 5. Find the first non-repeating character in a string
         */
        String string1 = "aabbccdee";
        string1.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
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
            return name.charAt(0) == name.charAt(name.length() - 1);
        }).collect(Collectors.toList());
        /*💥 8. Remove duplicate Strings from a list ignoring case*/
        List<String> strings1 = Arrays.asList("Java", "java", "Python", "python");
        strings1.stream().map(e -> e.toLowerCase()).distinct().collect(Collectors.toList());
        /*Capitalize first letter of each name in a list*/
        strings1.stream().map(name -> name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase())
                .collect(Collectors.toSet());
        //
        Map<Boolean, Long> result = employees.stream()
                .collect(Collectors.partitioningBy(
                        e -> e.getSalary() > 50000,
                        Collectors.counting()
                ));


        // List of Employee are there i need to only distinct items into a list
        List<Employee> employeesDistinct = employees.stream().distinct().collect(Collectors.toList());
        // what i need to get get employee objects only based on name
        List<Employee> employeeDistinctByName = employees.stream().collect(Collectors.toMap(Employee::getName, Function.identity(), (exiting, replacement) -> exiting))
                .values().stream().collect(Collectors.toList());


        List<Employee> distinctByName = employees.stream()
                .filter(distinctByKey(Employee::getName))
                .collect(Collectors.toList());

        // use flatmap
        List<List<String>> nested = Arrays.asList(
                Arrays.asList("a", "b"),
                Arrays.asList("c", "d"),
                Arrays.asList("e", "f")
        );
        List<String> flatMapEx = nested.stream().flatMap(l -> l.stream()).collect(Collectors.toList());
        List<String> flatEx = nested.stream().flatMap(Collection::stream).collect(Collectors.toList());

        int[] ints = {5, 3, 8, 3, 2, 1, 8, 7, 2};
        HashSet<Integer> set = new HashSet<>();
        OptionalInt first = Arrays.stream(ints)
                .filter(num -> !set.add(num))
                .skip(1)
                .findFirst();
        first.ifPresentOrElse(i -> System.out.println(i), () -> {
            System.out.println("not present");
        });
        // Asked in Infosys square even number and find the sum of them
        List<Integer> numsList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        numsList.stream()
                .filter(num -> num % 2 == 0)
                .map(num -> num * num)
                .reduce(0, (num1, num2) -> num1 + num2);

        numsList.stream()
                .filter(num -> num % 2 == 0)
                .mapToInt(num -> num * num)
                .sum();

        // Capegemini
        List<Integer> salaries = Arrays.asList(5000, 8000, 6000, 8000, 9000, 9000, 10000);
//        How would you leverage Java 8 Streams to compute the second highest distinct salary?
        Optional<Integer> secondHighest = salaries.stream().distinct().sorted(Collections.reverseOrder()).skip(1).findFirst();
        secondHighest.ifPresentOrElse((i) -> {
            System.out.println("second highest :" + i);
        }, () -> {
            System.out.println("not present");

        });

        // Revision of java 8 concepts
        /*1. Find the sum of all elemetns in the List*/
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
        integerList.stream().collect(Collectors.summingInt(Integer::intValue));
        integerList.stream().mapToInt(Integer::intValue).sum();
        IntStream intStream = Arrays.stream(new int[]{1, 3, 4, 5, 6});
        intStream.sum();
        /*Given list of Integers write a program to find max element*/
        integerList.stream().collect(Collectors.maxBy((a, b) -> a - b));
        integerList.stream().mapToInt(Integer::intValue).max();
        integerList.stream().max(Comparator.reverseOrder());
        /*3. Given string list count number of string that start with sepecific char*/
        List<String> stringList = Arrays.asList("Prashanth", "Navin", "Developer", "Dev");
        stringList.stream().filter(strrr -> strrr.startsWith("D")).count();
        /*4 convert to upper case*/
        stringList.stream().map(String::toUpperCase).collect(Collectors.toList());
        stringList.stream().map(strrr -> stringFunction.apply(strrr)).collect(Collectors.toList());

        /*5. Take list of Floating points and get avg*/
        List<Double> floats = Arrays.asList(1.1, 1.2, 3.3, 5.7, 9.7);
        floats.stream().mapToDouble(Double::doubleValue).average().getAsDouble();

        floats.stream().allMatch(d -> d > 1.0);
        /*next set of questions */
        /*given a sentance find and print the frequency*/
        String sentence = "hello my name is Prashanth";
        Arrays.stream(sentence.split("\\s+")).collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));

        /* given list of Integers to  start with 1 collect*/
        List<Integer> integerList1 = Arrays.asList(1,11,13,1,4,55);
        integerList1.stream().filter(integer -> String.valueOf(integer).startsWith("1")).collect(Collectors.toList());

        /* list of names then group them on basis of first letter and count*/
        List<String> namesList = Arrays.asList("Prashanth", "Praveen", "Uday", "ravi");
        namesList.stream().collect(Collectors.groupingBy(name -> name.charAt(0), Collectors.counting()));

        /*int array*/
        int[]array = {1,2,3,5,3,4,2,1};
        Arrays.stream(array).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(entry -> entry.getKey())
                .forEach(System.out::print);

        /* list of words print the palindromes*/
        List<String> wordsList = List.of("Prashanth", "malayalam","deed", "nayana");
        wordsList.stream().filter( word -> word.equals(new StringBuilder(word).reverse().toString()) ).forEach(System.out::print);
        /*Merge 2 sorted arrays*/
        int[]array1 = {1,3,5,7};
        int[]array2 = {2,4,6};
        int[] sortedArray = IntStream.concat(Arrays.stream(array1), Arrays.stream(array2)).sorted().toArray();

        /* remove duplicates from list ofString */

        List<String> stringList1 = Arrays.asList("Prashanth", "navin");
        List<String> stringList2 = Arrays.asList("Prashanth", "Navin");
        String concatinatedString = Stream.concat(stringList1.stream(), stringList2.stream()).distinct().collect(Collectors.joining(","));
    }

    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }

    static Function<String, String> stringFunction = (strToFun) -> strToFun.toUpperCase();


}
