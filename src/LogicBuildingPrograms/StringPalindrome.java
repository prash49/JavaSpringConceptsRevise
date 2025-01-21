package LogicBuildingPrograms;

public class StringPalindrome {
    public static void main(String[] args) {
        //palindrome means check if you reverse the string still it'll be same?

        // first reverse a String
        String input = "MALAYALAM";
        String rev = "";
        for (int i = input.length() -1 ; i >=0 ; i --){
            rev += input.charAt(i);
        }
        if(input.equals(rev)){
            System.out.println("Palindrome");
        }
        System.out.println("rev using StringBuilder:"+ new StringBuilder(input).reverse());
        System.out.println("res:"+ input.equals(new StringBuilder(input).reverse().toString()));
        if(input.equals(new StringBuilder(input).reverse())){
            System.out.println("Palindrommmmmmmmmmmmmee");
        }
        if(input.equals(new StringBuilder(input).reverse().toString())){
            System.out.println("Palindrommmmmmmmmmmmmee");
        }
    }

}
