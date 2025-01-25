package java8.functionalInterface;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Java8Programs {
    public static void main(String[] args) {
        String name = "Prashanth";

    Map<Character, Long> map = name.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,Collectors.counting()));
        Set<Map.Entry<Character,Long>> entrySet = map.entrySet();
        entrySet.stream().forEach(entry -> System.out.println("entry key:"+ entry.getKey() + " value"+ entry.getValue()));
    }


}

