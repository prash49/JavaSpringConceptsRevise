package LogicBuildingPrograms;

import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindFrequencyOfEachChar {

    public static void main(String[] args) {
        // we use java 8 for this
        "Prashanth".chars().mapToObj(c -> (char) c).map(Character::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,Collectors.counting()))
                .entrySet().forEach(
                        it -> System.out.println("key:"+ it.getKey() + " frequency:"+ it.getValue())
                );
    }
}
