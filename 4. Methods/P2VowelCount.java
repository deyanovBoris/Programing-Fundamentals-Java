/*
Write a method that receives a single string and prints the count of the vowels.
Use an appropriate name for the method.
 */
package Methods;

import java.util.Scanner;

public class P2VowelCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine();
        System.out.println(vowelCounter(word));
    }
    public static int vowelCounter(String word){
        String[] charArray = word.toLowerCase().split("|");
        int counter = 0;
        for (String letter : charArray){
            switch (letter){
                case "a":
                case "o":
                case "u":
                case "e":
                case "i": counter++;
            }
        }
        return counter;
    }
}
