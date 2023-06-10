/*
You will be given numbers (a list of integers) on the first input line.
Until you receive "End" you will be given operations you must apply on the list.
The possible commands are:
• Add {number} - add number at the end
• Insert {number} {index} - insert number at given index
• Remove {index} - remove that index
• Shift left {count} - first number becomes last 'count' times
• Shift right {count} - last number becomes first 'count' times
Note: The index given may be outside the array's bounds. In that case, print "Invalid index".
 */
package Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P4ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        while (true){
            String input = scanner.nextLine();

            if (input.equals("End")){
                break;
            }

            String[] inputArray = input.split(" ");
            String command = inputArray[0];
            switch (command){
                case "Add":
                    int numberToAdd = Integer.parseInt(inputArray[1]);
                    numbers.add(numberToAdd);
                    break;
                case "Insert":
                    int indexInsert = Integer.parseInt(inputArray[2]);
                    try {
                        int numberToInsert = Integer.parseInt(inputArray[1]);
                        numbers.add(indexInsert, numberToInsert);
                    } catch(Exception e) {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Remove":
                    int indexRemove = Integer.parseInt(inputArray[1]);
                    try {
                        numbers.remove(indexRemove);
                    } catch(Exception e) {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Shift":
                    String shiftDirection = inputArray[1];
                    int numberOfShifts = Integer.parseInt(inputArray[2]);

                    for (int i = 0; i < numberOfShifts; i++){
                        shifter(numbers, shiftDirection);
                    }
                    break;
            }
        }
        System.out.println(numbers.toString().replaceAll("[\\[\\],]",""));
    }

    public static void shifter(List<Integer> numbersList, String shiftDirection){
        switch (shiftDirection){
            case "right":
                int endNumber = numbersList.get(numbersList.size() - 1);
                for (int i = numbersList.size() - 1; i > 0; i--){
                    numbersList.set(i, numbersList.get(i - 1));
                }
                numbersList.set(0, endNumber);
                break;
            case "left":
                int startNumber = numbersList.get(0);
                for (int i = 0; i < numbersList.size() - 1; i++){
                    numbersList.set(i, numbersList.get(i + 1));
                }
                numbersList.set(numbersList.size() - 1, startNumber);
                break;
        }
    }

}
