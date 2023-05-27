package FundEx3;

import java.util.Scanner;

/*
Write a program that prints common elements in two arrays.
You have to compare the elements of the second array to the elements of the first.
*/

public class P2CommonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] stringArr1 = scanner.nextLine().split(" ");
        String[] stringArr2 = scanner.nextLine().split(" ");

        for (int i = 0; i < stringArr2.length ; i++ ){
            for(int j = 0; j < stringArr1.length; j++){
                if (stringArr2[i].equals(stringArr1[j])){
                    System.out.print(stringArr1[j] + " ");
                }
            }
        }
    }
}
