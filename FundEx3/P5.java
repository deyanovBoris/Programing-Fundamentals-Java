package FundEx3;

import java.util.Scanner;
import java.util.Arrays;

public class P5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();

        int numbersToCheck = numbers.length - 1;

        //Get number going from left to right
        for (int i = 0; i < numbers.length; i++){
            int biggerCounter = 0;
            //Choose the next number to compare from right to left
            for (int j = numbers.length - 1; j > i; j--){
                if (numbers[i] > numbers[j]){
                    biggerCounter++;
                }
            }
            if ((biggerCounter == numbersToCheck)){
                System.out.print(numbers[i] + " ");
            }
            numbersToCheck--;
        }
    }
}