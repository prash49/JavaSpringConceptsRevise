package LogicBuildingPrograms;

import java.util.Scanner;

public class StringCompressionAlgo {
    // problem statement : aaabbccccdeadbcd --> abcdeadbcd
    public static void main(String[] args) {
        // in this we need to check if previous char is same as current then won't attach in a string
        String str = "aabcdddedddeeeaa";
        System.out.println("compressed string:" + compressedString(str));
        // again compresse below char like a2bcd3ed3e3a2 --> a two occurance, b one occurance, d3 occurance
        System.out.println("compressed string2:" + compressedString2(str));
    }

    static String compressedString(String input) {

        String s = String.valueOf(input.charAt(0));

        for (int i = 1; i < input.length() ; i++){
            char currentChar = input.charAt(i);
            char prevChar = input.charAt(i - 1);
            if(currentChar != prevChar){
                s += currentChar;
            }
        }
        return s;
    }
    static String compressedString2(String input) {

        String s = String.valueOf(input.charAt(0));
        int counter = 1;
// a
        for (int i = 1; i < input.length() ; i++){
            char currentChar = input.charAt(i);
            char prevChar = input.charAt(i - 1);
            if(currentChar == prevChar){
                counter +=1;
            }
            if (currentChar != prevChar ){
                if(counter !=1){
                    s +=counter ;
                    counter = 1;

                }
                s +=currentChar ;
            }
        }
        if (counter > 1){
            s+=counter;
        }
        return s;
    }
}
