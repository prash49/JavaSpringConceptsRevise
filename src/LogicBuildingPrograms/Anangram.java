package LogicBuildingPrograms;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Anangram {
    // means a if two string have same chars
    // ex: NOW and WON or ONE or NEO
    public static void main(String[] args) {
        String s1 = "ONE";
        String s2 = "NEO";

        if (s1.length() != s2.length()) {
            System.out.println("not anagram");
        } else {
            char[] ch1 = s1.toCharArray();
            Arrays.sort(ch1);
            char[] ch2 = s2.toCharArray();
            Arrays.sort(ch2);

            if (Arrays.equals(ch1, ch2)) {
                System.out.println("Anagarm");
            } else System.out.println("Not a anagram");
        }
    }
}
