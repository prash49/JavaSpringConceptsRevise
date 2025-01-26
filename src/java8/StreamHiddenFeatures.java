package java8;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamHiddenFeatures {

    public static void main(String[] args) {
        //1. StreamOfnullable
        // helps filter all the null value from stream introduced in java 9
        List<String> names = Arrays.asList("Prashanth", null, "Pravin");
        List<String> result = names.stream().filter(name -> name != null).collect(Collectors.toList());
        System.out.println(result);
        List<Stream<String>> re = names.stream().map(Stream::ofNullable).collect(Collectors.toList());
        List<String> result2 = names.stream().flatMap(Stream::ofNullable).collect(Collectors.toList());

        names.stream().flatMap(Stream::ofNullable).max((o1, o2) -> o1.compareTo(o2)).stream().forEach(System.out::println);
        //Stream.iterate
        //creating infinite stream --> can be used where i need to generate sequence of number
        Stream.iterate(0, n -> n + 1).limit(5).forEach(System.out::println);
        //Collectors.collectingAndThen

        //collections.partioningBy
        // partion the list by two diff stream by some condtion
        List<Integer> nums = Stream.iterate(0, n -> n + 1).limit(10).toList();
        Map<Boolean, List<Integer>> map = nums.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println(map);
        System.out.println(map.get(true));
        System.out.println(map.get(false));
        IntStream.range(0, 10);

        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1, "male", "prashanth", 100, "ECE", "Karnataka"));
        studentList.add(new Student(2, "male", "navin", 99, "ECE", "AP"));
        studentList.add(new Student(3, "male", "pras", 10, "ECE", "TN"));
        studentList.add(new Student(4, "male", "prashanth", 1, "ECE", "TS"));
        studentList.add(new Student(5, "male", "prashanth", 4, "ECE", "Karnataka"));

        // filter
        studentList.stream().filter( s -> s.rank > 20 && s.rank < 100).forEach(System.out::println);
        // filter and sort
        studentList.stream().filter(s -> s.state.equals("Karnatak")).sorted(Comparator.comparing(Student::getName, Collections.reverseOrder()));
       //department name distinct
        studentList.stream().map(Student::getName).distinct();
        studentList.stream().map(Student::getDept).collect(Collectors.toSet());
        // grop the students based on dept
        studentList.stream().collect(Collectors.groupingBy(Student::getDept));
        studentList.stream().collect(Collectors.groupingBy(Student::getDept, Collectors.counting()));
        studentList.stream().collect(Collectors.groupingBy(Student::getDept, Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue());
        Map<String, Double> collect = studentList.stream().collect(Collectors.groupingBy(Student::getGender, Collectors.averagingInt(Student::getRank)));
        Student student = new Student(1, "male", "prashanth", 100, "ECE", "Karnataka");
        Optional<String> gender = Optional.ofNullable(student.getGender());
        // i'll go for Optinal.ofNullable when i know there will be null and .of when i'm sure i'll get non nullable
        System.out.println(gender.orElse("Null value"));

    }
    //



}

class Student {
    int id;
    String name;
    String gender;
    int rank;
    String dept;
    String state;

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getRank() {
        return rank;
    }

    public String getDept() {
        return dept;
    }

    public String getState() {
        return state;
    }

    public Student(int id, String gender, String name, int rank, String dept, String state) {
        this.id = id;
        this.gender = gender;
        this.name = name;
        this.rank = rank;
        this.dept = dept;
        this.state = state;
    }
}