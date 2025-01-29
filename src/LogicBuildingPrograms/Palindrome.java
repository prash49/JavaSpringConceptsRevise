package LogicBuildingPrograms;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println(palindrome(4));
    }

    static int palindrome(int n) {
        int mul = 1;
        for (int i = n; i >= 1; i--) {
            System.out.println(i);
            mul = mul * i;
        }
        return mul;
    }
}
