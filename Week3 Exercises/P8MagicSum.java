package FundEx3;

import java.util.Arrays;
import java.util.Scanner;

/*
Write a program that prints all unique pairs in an array of integers whose sum is equal to a given number.
*/

public class P8MagicSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input array of numbers
        int[] numbersArray = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();

        int targetValue = Integer.parseInt(scanner.nextLine());

        // Get first element of array to sum up.
        for (int i = 0; i < numbersArray.length; i++) {
            // Sum up the second number starting from the back to the front of the
            // array. This is to avoid double counting (e.g. 7 and 6 and 6 and 7 being output).
            for (int j = numbersArray.length - 1; j > i; j--) {
                if (numbersArray[i] + numbersArray[j] == targetValue) {
                    System.out.printf("%d %d%n", numbersArray[i], numbersArray[j]);
                }
            }
        }
    }
}
