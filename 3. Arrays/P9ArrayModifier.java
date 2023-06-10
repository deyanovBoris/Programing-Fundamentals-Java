package FundEx3;

import java.util.Arrays;
import java.util.Scanner;

/*
You are given an array with integers. Write a program to modify the elements after receiving the following commands:
    • "swap {index1} {index2}" takes two elements and swap their places.
    • "multiply {index1} {index2}" takes the element at the 1st index and multiplies it with the element
       at 2nd index. Save the product at the 1st index.
    • "decrease" decreases all elements in the array with 1.
*/

public class P9ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input array of numbers
        int[] numbersArray = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();

        String command = scanner.nextLine();

        while (!command.equals("end")) {
            if (command.equals("decrease")) {
                for (int i = 0; i < numbersArray.length; i++) {
                    numbersArray[i] = numbersArray[i] - 1;
                }
            } else {
                // input complex command to parse its elements
                String[] commandArray = command.split(" ");
                String operation = commandArray[0];
                int indexOne = Integer.parseInt(commandArray[1]);
                int indexTwo = Integer.parseInt(commandArray[2]);

                // determining and executing the operation
                switch (operation) {
                    case "multiply":
                        numbersArray[indexOne] =
                                numbersArray[indexOne] * numbersArray[indexTwo];
                        break;
                    case "swap":
                        int numberIndexTwo = numbersArray[indexTwo];
                        numbersArray[indexTwo] = numbersArray[indexOne];
                        numbersArray[indexOne] = numberIndexTwo;
                        break;
                    default:
                        System.out.println("Unknown command");
                        break;
                }
            }
            // enter the next command
            command = scanner.nextLine();
        }
        // Printing output
        for (int j = 0; j < numbersArray.length - 1; j++) {
            System.out.print(numbersArray[j] + ", ");
        }
        System.out.print(numbersArray[numbersArray.length - 1]);
    }
}
