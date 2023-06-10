package FundEx3;

import java.util.Arrays;
import java.util.Scanner;

/*
Write a program that determines if an element exists in the array such that
the sum of the elements on its left is equal to the sum of the elements on
its right. If there are no elements to the left/right, their sum is considered
to be 0.
Print the index that satisfies the required condition or "no" if there is no such index.
*/

public class P6EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Input integers as one line separated by spaces
        int[] numbersArray = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();

        boolean equalSums = false;

        for (int i = 0; i < numbersArray.length; i++) {
            int leftSum = 0;
            int rightSum = 0;

            // Left sum
            for (int j = 0; j < i; j++) {
                leftSum += numbersArray[j];
            }
            // Right sum
            for (int k = i + 1; k < numbersArray.length; k++) {
                rightSum += numbersArray[k];
            }

            if (leftSum == rightSum) {
                System.out.println(i);
                equalSums = true;
                break;
            }
        }
        if (!equalSums)
            System.out.println("no");
    }
}
