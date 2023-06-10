/*
On the first line, you will be given a list of wagons (integers).
Each integer represents the number of passengers that are currently in each wagon.
On the next line, you will get the max capacity of each wagon (single integer).
Until you receive "end" you will be given two types of input:
• Add {passengers} - add a wagon to the end with the given number of passengers
• {passengers} - find an existing wagon to fit all the passengers (starting from the first wagon)
In the end, print the final state of the train (all the wagons separated by a space)
 */
package Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P1Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> trainCarriages = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int maxCapacity = Integer.parseInt(scanner.nextLine());

        while (true) {
            String command = scanner.nextLine();

            if (command.equals("end")) {
                break;
            }
            carriageCalculator(command, trainCarriages, maxCapacity);
        }

        System.out.println(trainCarriages.toString().replaceAll("[\\[\\],]", ""));
    }
    public static void carriageCalculator(String command, List<Integer> trainCarriages, int maxCapacity) {
        String[] commandArray = command.split(" ");
        switch (commandArray[0]) {
            case "Add":
                int passangersToAdd = Integer.parseInt(commandArray[1]);
                if (passangersToAdd == 0) {
                    trainCarriages.add(passangersToAdd);
                } else {
                    for (int i = 0; i < passangersToAdd / maxCapacity; i++) {
                        trainCarriages.add(maxCapacity);
                    }
                    if (passangersToAdd % maxCapacity != 0) {
                        trainCarriages.add(passangersToAdd % maxCapacity);
                    }
                }
                break;
            default:
                int passangersToDist = Integer.parseInt(commandArray[0]);
                for (int i = 0; i < trainCarriages.size(); i++) {
                    if (passangersToDist + trainCarriages.get(i) <= maxCapacity) {
                        trainCarriages.set(i, passangersToDist + trainCarriages.get(i));
                        break;
                    }
                }
                break;
        }
    }
}
