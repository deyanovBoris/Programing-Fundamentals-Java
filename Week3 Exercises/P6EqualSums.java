package FundEx3;

import java.util.Arrays;
import java.util.Scanner;

public class P6EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

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
