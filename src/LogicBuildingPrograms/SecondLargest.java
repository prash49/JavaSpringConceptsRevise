package LogicBuildingPrograms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class SecondLargest {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        int secondLargest = Integer.MIN_VALUE;
        int largest = Integer.MIN_VALUE;

        for (int number : numbers) {
            if (number > largest) {
                secondLargest = largest;
                largest = number;
            } else if (number > secondLargest && number != largest) {
                secondLargest = number;
            }
        }

        System.out.println("Second largest element: " + secondLargest);
    }
}