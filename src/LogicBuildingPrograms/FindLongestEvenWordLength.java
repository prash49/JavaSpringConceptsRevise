package LogicBuildingPrograms;

public class FindLongestEvenWordLength {
    public static void main(String[] args) {
        String input = "Find the longest even length word in this sentence";
        int length = longestEvenWordLength(input);
        System.out.println("Length of the longest even length word: " + length);

    }

    private static int longestEvenWordLength(String input) {
        String[] words = input.split(" ");
        int maxEvenWordLength = 0;
        for (String word : words) {
              if(word.length() % 2 == 0){
                  maxEvenWordLength = Math.max(maxEvenWordLength, word.length());
              }
        }
        return maxEvenWordLength;
    }
}
