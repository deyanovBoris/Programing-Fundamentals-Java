package FundEx3;

import java.util.Scanner;
import java.util.Arrays;

/*
Write a program to find all the top integers in an array. 
A top integer is an integer that is bigger than all the elements to its right.
*/

public class P5TopIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        //Input array as a single line of integer numbers separated with a space.
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
