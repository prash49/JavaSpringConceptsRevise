package java8;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Anagram {
    public static void main(String[] args) {

        /*two strings are considered anagrams if they have the same characters with the same frequency,
         but the order of the characters is different. For example,
          “listen” and “silent” are anagrams because you can rearrange the letters in one to form the other.*/
        String s1 = "listen";
        String s2 = "silent";
        System.out.println( "isGiven Strings are anagaram: "+checkIfAnagaram(s1, s2));

    }

    static boolean checkIfAnagaram(String s1, String s2) {

//        Map<Character, Long> collect = s1.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        Map<Character, Integer> str1Map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            str1Map.put((char) s1.charAt(i), str1Map.getOrDefault(s1.charAt(i), 1));
        }
        System.out.println(str1Map);
        Map<Character, Integer> str2Map = new HashMap<>();
        for (int i = 0; i < s2.length(); i++) {
            str2Map.put((char) s2.charAt(i), str2Map.getOrDefault(s1.charAt(i), 1));
        }
        System.out.println(str2Map);
        Set<Character> entries = str1Map.keySet();
        for(char ch : entries){
            if(str1Map.get(ch) == str2Map.get(ch)){
                return true;
            }
        }
// how to define a
        Set<Map.Entry<Character, Integer>> entries1 = str1Map.entrySet();
        for (Map.Entry<Character, Integer> characterIntegerEntry : str1Map.entrySet()) {
            if(str1Map.get(characterIntegerEntry.getKey()) == str2Map.get(characterIntegerEntry.getKey())){
                return true;
            }
        }

        return false;
    }

}
