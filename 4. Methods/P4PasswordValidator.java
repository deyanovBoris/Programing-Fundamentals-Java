/*
You will receive a single string. Write a method that prints the middle character.
If the length of the string is even, there are two middle characters.
*/

package Methods;

import java.util.Scanner;

public class P4PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String passwordCandidate = scanner.nextLine();

        if (!isLongEnough(passwordCandidate)) {
            System.out.println("Password must be between 6 and 10 characters");
        }
        if (!isLetterOrDigit(passwordCandidate)) {
            System.out.println("Password must consist only of letters and digits");
        }
        if (!hasTwoDigits(passwordCandidate)) {
            System.out.println("Password must have at least 2 digits");
        }

        if (isLongEnough(passwordCandidate) && isLetterOrDigit(passwordCandidate)
                && hasTwoDigits(passwordCandidate)) {
            System.out.println("Password is valid");
        }
    }

    public static boolean isLongEnough(String password) {
        return password.length() >= 6 && password.length() <= 10;
    }

    public static boolean isLetterOrDigit(String password) {
        String[] passwordArray = password.split("|");
        boolean isValid = true;
        for (String character : passwordArray) {
            int intChar = (int) character.charAt(0);
            if ((intChar >= 48 && intChar <= 57)
                    || (intChar >= 65 && intChar <= 90)
                    || (intChar >= 97 && intChar <= 122)) {
            } else {
                isValid = false;
                break;
            }
        }
        return isValid;
    }

    public static boolean hasTwoDigits(String password) {
        int digitCounter = 0;
        String[] passwordArray = password.split("|");
        for (String character : passwordArray) {
            int intChar = (int) character.charAt(0);
            if (intChar >= 48 && intChar <= 57) {
                digitCounter++;
                if (digitCounter == 2)
                    return true;
            }
        }
        return false;
    }
}
