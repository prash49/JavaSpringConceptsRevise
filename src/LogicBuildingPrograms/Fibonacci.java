package LogicBuildingPrograms;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(finbonacci(5));
//        F0 = 0, F1=1, F2=1,F3 = 2, F4=3,F5 = 5
    }

    static int finbonacci(int n) {
       int first = 0;
       int second = 1;
       int fibo = 0;
       for(int i = 1; i < n ; i ++){
           fibo = first + second;
           first  = second;
           second =fibo;
       }
       return fibo;
    }
}
