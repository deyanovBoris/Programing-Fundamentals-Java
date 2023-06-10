/*
Read two integer numbers. Calculate the factorial of each number.
Divide the first result by the second and print the division formatted to the second decimal point.
 */

package Methods;
import java.util.Scanner;

public class P8FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOne = Integer.parseInt(scanner.nextLine());
        int numberTwo = Integer.parseInt(scanner.nextLine());

        double result = factorial(numberOne)/factorial(numberTwo);
        System.out.printf("%.2f", result);

    }
    public static double factorial(int number){
        double result = 1;

        for (int i = 1; i <= number; i++){
            result = result*i;
        }
        return result;
    }
}
