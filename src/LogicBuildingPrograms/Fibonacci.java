package LogicBuildingPrograms;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(finbonacci(4));
    }

    static int finbonacci(int n) {
        int mul = 1;
        for (int i = n; i >= 1; i--) {
            System.out.println(i);
            mul = mul * i;
        }
        return mul;
    }
}
