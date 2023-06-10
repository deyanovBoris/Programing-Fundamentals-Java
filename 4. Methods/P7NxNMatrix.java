/*
Write a method that receives a single integer n and prints an nxn matrix with that number.
 */

package Methods;

import java.util.Scanner;

public class P7NxNMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputValue = Integer.parseInt(scanner.nextLine());

        matrix(inputValue);
    }

    public static void matrix(int number){
        for (int i = 0; i < number; i++){
            for (int j = 0; j < number; j++){
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }
}
