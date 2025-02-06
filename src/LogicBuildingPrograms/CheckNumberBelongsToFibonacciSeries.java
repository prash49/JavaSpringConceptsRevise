package LogicBuildingPrograms;

import java.util.Scanner;

public class CheckNumberBelongsToFibonacciSeries {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter the number to check the given number is in fibonacci series or not");
        int input = scanner.nextInt();
        findTheNumberInFibonacci(input);


    }
   static  void  findTheNumberInFibonacci(int input){
        int firstNumber = 0;
        int secondNumber = 1;
        int thirdNumber = 0;
        while (thirdNumber < input){
            thirdNumber = firstNumber + secondNumber;
            firstNumber = secondNumber;
            secondNumber  = thirdNumber;
        }
        if (thirdNumber == input){
            System.out.println("its there in fibonacci");
        }else System.out.println("not present");

    }
}
