package FundEx3;

import java.util.Scanner;
import java.util.Arrays;

/*
Write a program that finds the longest sequence of equal elements in an array of integers.
If several longest sequences exist, print the leftmost one.
*/

public class P7MaxSequenceOfEqualElements
{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int maxCounter = Integer.MIN_VALUE;
        int maxValue = 0;

        //Input array of numbers
        int[] numbersArray = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();

        //Go through array from back to front.
        for (int i = numbersArray.length - 1; i >= 0 ; i--){
            int counter = 1;
            //Check each element from back to front until not the same.
            for(int j = i - 1; j >= 0; j--){
                if (numbersArray[j] != numbersArray[i]){
                    break;
                } else {
                    counter++;
                }
            }
            //Check if maximum needs to be updated
            if (counter >= maxCounter){
                maxCounter = counter;
                maxValue = numbersArray[i];
            }
        }
        //Print the maximum occuring value the number of times it occured consecutiely.
        for (int l = 0; l < maxCounter; l++){
            System.out.printf("%d ", maxValue);
        }
    }
}
