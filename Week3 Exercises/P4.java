package FundEx3;

import java.util.Scanner;

public class P4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputArray = scanner.nextLine().split(" ");
        int arrayLength = inputArray.length;

        int numIterations = Integer.parseInt(scanner.nextLine());

        String[] outputArray = new String[arrayLength];

        if (numIterations == 0) {
            System.out.println(String.join(" ", inputArray));
        } else {
            for (int i = 0; i < numIterations; i++) {
                for (int j = 1; j < arrayLength; j++) {
                    outputArray[j - 1] = inputArray[j];
                }
                outputArray[arrayLength - 1] = inputArray[0];
                inputArray = outputArray.clone();
            }
            System.out.println(String.join(" ", outputArray));
        }
    }
}