package LogicBuildingPrograms;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindFirstNonRepeatingchar {
    public static void main(String[] args) {
        String input = "Prashanth";
        // we can't use map here because it maintain insertion order

     /*   Map<Character, Long> map = input.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        map.entrySet().forEach( it ->
                System.out.println("key :"+ it.getKey() + " value:" +it.getValue())
        );*/

        LinkedHashMap<Character,Long> characterLongMap = input.chars().mapToObj(e -> (char) e).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
        characterLongMap.entrySet().forEach(
                it ->
                        System.out.println("Key: "+ it.getKey() + " value:"+ it.getValue() )
        );
        Optional<Character> firstChar =   characterLongMap.entrySet().stream().filter(e -> e.getValue() == 1).map(e -> e.getKey()).findFirst();
        firstChar.ifPresent( e -> System.out.println("character "+ e));

        firstChar.ifPresentOrElse(
                e -> System.out.println("first char"+ e),
                () -> System.out.println("Not found")

        );

        // combing both
        "NNNNN".chars().mapToObj(e -> (char) e)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))// linked hashmap stores the insertion order
                .entrySet()
                .stream()
                .filter(ch -> ch.getValue() ==1)
                .map(e -> e.getKey())// this can be written as .map(Map.Entry::getKey
                .findFirst().ifPresentOrElse(
                        i -> System.out.println("first non repeating char"+ i),
                                () -> System.out.println("not found any"));
    }
}
