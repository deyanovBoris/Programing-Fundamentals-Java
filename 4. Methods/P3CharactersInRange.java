/*
Write a method that receives two characters and prints all
the characters in between them on a single line according to ASCII.
 */

package Methods;
import java.util.Scanner;

public class P3CharactersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputA = scanner.nextLine();
        String inputB = scanner.nextLine();

        System.out.println(charPrinter(inputA, inputB));
    }

    public static String charPrinter(String a, String b){
        char charA = a.charAt(0);
        char charB = b.charAt(0);
        String output = "";

        if ((int) charA < (int) charB) {
            for (int i = (int) charA + 1; i < (int) charB; i++){
                String character = (char) i + "";
                output += character + " ";
            }
        } else {
            for (int i = (int) charB + 1; i < (int) charA; i++){
                String character = (char) i + "";
                output += character + " ";
            }
        }
        return output;
    }
}
