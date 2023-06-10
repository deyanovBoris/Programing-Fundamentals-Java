/*
Read an integer n from the console. Find all top numbers in the range [1 ... n] and print them.
A top number holds the following properties:
• Its sum of digits is divisible by 8, e.g. 8, 16, 88.
• Holds at least one odd digit, e.g. 232, 707, 87578.
 */
package Methods;
import java.util.Scanner;

public class P10TopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= number; i++){
            if(isDivByEight(i) && atLeastOneOdd(i)){
                System.out.println(i);
            }
        }
    }
    public static boolean isDivByEight(int number){
        int sumOfDigits = 0;
        while(number > 0){
            sumOfDigits += number%10;
            number = number / 10;
        }
        if (sumOfDigits % 8 == 0){
            return true;
        }
        return false;
    }
    public static boolean atLeastOneOdd(int number){
        while(number > 0){
            int digit = number % 10;
            if(digit % 2 != 0){
                return true;
            }
            number = number / 10;
        }
        return false;
    }
}
