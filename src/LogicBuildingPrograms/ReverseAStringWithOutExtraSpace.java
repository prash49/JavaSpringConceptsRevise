package LogicBuildingPrograms;

public class ReverseAStringWithOutExtraSpace {
    // Reverse a String
    public static void main(String[] args) {
        String input = "Prashanth";
        StringBuilder stringBuilder = new StringBuilder(input);
        // typically we use above if not
        String rev = "";
        for (int i=input.length() -1; i >= 0; i--){
            rev += input.charAt(i);
        }
        System.out.println("reverse:" + rev + " using string builder:"+ stringBuilder.reverse());

        // now without the Extra var using two pointer approach
        char[] charArray = input.toCharArray();
        int start  =0;
        int end = charArray.length -1 ;
        while (start < end){
            charArray[start] ^= charArray[end];
            charArray[end] ^= charArray[start];
            charArray[start] ^= charArray[end];

            start ++;
            end --;
        }
        System.out.println("rev "+ new String(charArray));
    }
    static void swap(char ch,char ch2){

    }
}
