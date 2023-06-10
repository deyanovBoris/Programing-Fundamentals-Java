/*
Write a program that reads a sequence of numbers and a special bomb number with a certain power.
Your task is to detonate every occurrence of the special bomb number and according to its power
- his neighbors from left and right.
Detonations are performed from left to right, and all detonated numbers disappear.
Finally, print the sum of the remaining elements in the sequence.

Ex: input: 1 2 2 4 2 2 2 9 and 4 2 -> 1 -2- -2- *4* -2- -2- 2 9 -> 1 2 9 -> 12
 */
package Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P5BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int[] bombDefinition = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();

        int bombNumber = bombDefinition[0];
        int bombPower = bombDefinition[1];

        //Remove numbers on the right side of bomb
        outer:
        for (int i = 0; i < numbers.size(); i++){
            if (numbers.get(i) == bombNumber){
                for (int j = 0; j < bombPower; j++){
                    try {
                        numbers.remove(i + 1);
                    } catch(Exception e) {
                        continue outer;
                    }
                }
            }
        }
        //Remove numbers on the left side of bomb including bomb
        for (int i = numbers.size() - 1 ; i >= 0; i--){
            if (numbers.get(i) == bombNumber){
                for (int j = 0; j <= Math.min(bombPower, i); j++){
                    numbers.remove(i - j);
                }
                i -= bombPower;
            }
        }
        //Print sum of remaining numbers
        System.out.println(sumList(numbers));
    }
    public static int sumList(List<Integer> intList){
        int sum = 0;
        for (int number : intList){
            sum += number;
        }
        return sum;
    }
}
