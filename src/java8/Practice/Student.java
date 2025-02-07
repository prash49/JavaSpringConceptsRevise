package java8.Practice;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Student {
    String name;

    int id;

    String subject;

    double percentage;

    public Student(String name, int id, String subject, double percentage) {
        this.name = name;
        this.id = id;
        this.subject = subject;
        this.percentage = percentage;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public double getPercentage() {
        return percentage;
    }

    @Override
    public String toString() {
        return name + "-" + id + "-" + subject + "-" + percentage;
    }


    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Prashanth", 105, "Computers", 90));
        studentList.add(new Student("Prashanth", 105, "Kannada", 80));
        studentList.add(new Student("Prashanth", 105, "English", 75));
        studentList.add(new Student("Prashanth", 105, "Mathematics", 50));
        studentList.add(new Student("Prashanth", 105, "Physics", 85));
        studentList.add(new Student("Prashanth", 105, "Chemistry", 55));
        studentList.add(new Student("Praveen", 105, "Computers", 90));
        studentList.add(new Student("Navin", 105, "Kannada", 80));
        studentList.add(new Student("Pranov", 105, "English", 75));
        studentList.add(new Student("Uday", 105, "Mathematics", 50));
        studentList.add(new Student("Ravi", 105, "Physics", 85));
        studentList.add(new Student("Ranjitha", 105, "Chemistry", 55));

        // Given a list of students, write a Java 8 code to partition the students who got above 60% from those who didn’t?
        // first collect to map who all are got the above 60 based on subject
        studentList.stream().filter(s -> s.getPercentage() > 60).collect(Collectors.toMap(Student::getSubject, Function.identity()));
        // now Partion them
        studentList.stream().collect(Collectors.partitioningBy(s -> s.getPercentage() > 60));
        //Given a list of students, write a Java 8 code to get the names of top 3 performing students based on percentage?
        studentList.stream().sorted(Comparator.comparingDouble(Student::getPercentage).reversed()).limit(3).collect(Collectors.toList());
        //49) Given a list of students, how do you get the name and percentage of each student?
        studentList.stream().collect(Collectors.toMap(Student::getName, Student::getPercentage));
//        50) Given a list of students, how do you get the subjects offered in the college?
        studentList.stream().map(Student::getSubject).distinct();
        studentList.stream().map(Student::getSubject).collect(Collectors.toSet());
//) Given a list of students, write a Java 8 code to get highest, lowest and average percentage of students?
        DoubleSummaryStatistics percentagesummarize = studentList.stream().collect(Collectors.summarizingDouble(Student::getPercentage));
        percentagesummarize.getMax();
        //52) How do you get total number of students from the given list of students?
        studentList.stream().count();
//53) How do you get the students grouped by subject from the given list of students?
        studentList.stream().collect(Collectors.groupingBy(Student::getSubject));

    }
}