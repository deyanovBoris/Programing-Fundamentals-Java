/*
A palindrome is a number that reads the same backward as forward, such as 323 or 1001.
Write a program that reads a positive integer number until you receive "END".
For each numbered print, whether the number is palindrome or not.
 */

package Methods;
import java.util.Scanner;

public class P9PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        while(!input.equals("END")){
            System.out.println(palindrome(Integer.parseInt(input)));
            input = scanner.nextLine();
        }
    }

    public static boolean palindrome(int number){
        String numString = number + "";
        String[] numStringArray = numString.split("|");
        String reversedNumString = "";
        for (int i = numStringArray.length - 1; i >= 0; i--){
            reversedNumString += numStringArray[i];
        }
        return Integer.parseInt(reversedNumString) == number;
    }
}
