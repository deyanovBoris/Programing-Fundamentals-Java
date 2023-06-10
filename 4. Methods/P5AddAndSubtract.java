/*
You will receive 3 integers. Write a method sum to get the sum of the first two integers
and subtract the method that subtracts the third integer from the result from the sum method.
 */

package Methods;

import java.util.Scanner;

public class P5AddAndSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOne = Integer.parseInt(scanner.nextLine());
        int numTwo = Integer.parseInt(scanner.nextLine());
        int numThree = Integer.parseInt(scanner.nextLine());

        System.out.println(subtract(sum(numOne, numTwo), numThree));
    }

    public static int sum(int intA, int intB){
        return intA + intB;
    }

    public static int subtract(int intA, int intB){
        return intA - intB;
    }
}
