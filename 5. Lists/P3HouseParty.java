/*
Write a program that keeps track of guests going to a house party.
On the first input line, you are going to receive how many commands you are going to have.
On the next lines you are going to receive some of the following inputs:
• "{name} is going!"
• "{name} is not going!"
If you receive the first type of input, you have to add the person if he/she is not on the list.
If he/she is in the list, print on the console: "{name} is already in the list!".
If you receive the second type of input, you must remove the person if he/she is on the list.
If not, print: "{name} is not in the list!". In the end, print all guests.
 */
package Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P3HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> partyGoers = new ArrayList<>();

        int numberOfOperations = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfOperations; i++){
            List<String> input = Arrays.stream(scanner.nextLine().split(" "))
                    .collect(Collectors.toList());
            String guest = input.get(0);
            if (!input.contains("not")){
                if (!partyGoers.contains(guest)){
                    partyGoers.add(guest);
                } else {
                    System.out.printf("%s is already in the list!%n", guest);
                }
            } else {
                if (partyGoers.contains(guest)){
                    partyGoers.remove(guest);
                } else {
                    System.out.printf("%s is not in the list!%n", guest);
                }
            }
        }
        printGuests(partyGoers);
    }
    public static void printGuests(List<String> guestList){
        for(String guest : guestList){
            System.out.println(guest);
        }
    }
}
