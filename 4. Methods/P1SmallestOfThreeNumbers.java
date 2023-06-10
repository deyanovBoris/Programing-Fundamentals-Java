
/* Write a method to print the smallest of three integer numbers.
Use an appropriate name for the method.
 */

package Methods;
import java.util.Scanner;

public class P1SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //inputting three numbers line by line inside array
        int[] numberArray = new int[3];
        for (int i = 0; i < 3; i++){
            numberArray[i] = Integer.parseInt(scanner.nextLine());
        }

        System.out.println(minimumValue(numberArray));
    }

    public static int minimumValue(int[] numbers){
        int minVal = Integer.MAX_VALUE;
        for(int x : numbers){
            if (x < minVal) minVal = x;
        }
        return minVal;
    }
}
