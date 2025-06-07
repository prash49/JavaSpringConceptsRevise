package LogicBuildingPrograms;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Anangram {
    // means a if two string have same chars
    // ex: NOW and WON or ONE or NEO
    public static void main(String[] args) {
        String s1 = "one";
        String s2 = "neo";

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
        System.out.println("anagram check using new approach");
        System.out.println("is anagram?:"+ isAnagram(s1,s2));
    }
    // approach 2

    public static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] chars = new int[26];
        for (int i = 0; i < s1.length(); i++){
            chars[ s1.charAt(i) - 'a']++;
            System.out.print( " chars from first string:"+chars[s1.charAt(i) - 'a']);
            chars[s2.charAt(i) - 'a'] --;
            System.out.print( " chars from second string:"+chars[i]);
        }
        for (int c : chars){
            if (c != 0) return false;
        }
            return true;
    }
}
