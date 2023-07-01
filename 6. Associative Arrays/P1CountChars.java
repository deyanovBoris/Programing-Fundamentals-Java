/*
Write a program that counts all characters in a string except space (' ').
Print all occurrences in the following format:
"{char} -> {occurrences}"
 */


package AssocArrays;

import java.util.*;

public class P1CountChars
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().replaceAll(" ", "").split("");
        Map<String, Integer> letters = new LinkedHashMap<>();

        for (String letter : input){
            letters.putIfAbsent(letter, 0);
            letters.put(letter, letters.get(letter) + 1);
        }

        for(Map.Entry<String, Integer> entry : letters.entrySet()){
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}