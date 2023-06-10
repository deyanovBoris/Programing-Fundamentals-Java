/*
You will receive a single string. Write a method that prints the middle character.
If the length of the string is even, there are two middle characters.
 */

package Methods;

import java.util.Scanner;

public class P6MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        System.out.println(middleChars(input));
    }

    public static String middleChars(String input){
        String[] stringArray = input.split("|");
        boolean isEven = (stringArray.length % 2 == 0);
        String output = "";

        if (isEven){
            output = stringArray[stringArray.length/2 - 1] + stringArray[stringArray.length/2];
        } else {
            output = stringArray[stringArray.length/2];
        }

        return output;
    }
}
