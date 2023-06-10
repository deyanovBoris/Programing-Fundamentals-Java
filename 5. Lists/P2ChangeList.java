/*
Write a program that reads a list of integers from the console and receives commands which manipulate the list.
Your program may receive the following commands:
• Delete {element} - delete all elements in the array which are equal to the given element
• Insert {element} {position} - insert element at the given position
You should stop the program when you receive the command "end".
Print all numbers in the array, separated with a single whitespace.
 */
package Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P2ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        while (true){
            String command = scanner.nextLine();

            if (command.equals("end")){
                break;
            }

            String[] commandArray = command.split(" ");
            switch (commandArray[0]){
                case "Delete":
                    int numberToDelete = Integer.parseInt(commandArray[1]);
                    while(numbers.contains(numberToDelete)){
                        numbers.remove(Integer.valueOf(numberToDelete));
                    }
                    break;
                case "Insert":
                    int index = Integer.parseInt(commandArray[2]);
                    int numberToInsert = Integer.parseInt(commandArray[1]);
                    numbers.add(index, numberToInsert);
            }
        }
        System.out.println(numbers.toString().replaceAll("[\\[\\],]",""));
    }
}
