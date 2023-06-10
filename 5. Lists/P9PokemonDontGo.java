/*
You will receive a sequence of integers, separated by spaces - the distances to the Pokémons.
Then you will begin receiving integers corresponding to indexes in that sequence.
When you receive an index, you must remove the element at that index from the sequence (as if you've captured the Pokémon).
• You must INCREASE the value of all elements in the sequence which are LESS or EQUAL to the removed element with
    the value of the removed element.
• You must DECREASE the value of all elements in the sequence which are GREATER than the removed element with
    the value of the removed element.
If the given index is LESS than 0, remove the first element of the sequence, and COPY the last element to its place.
If the given index is GREATER than the last index of the sequence, remove the last element from the sequence, and
    COPY the first element to its place.
The increasing and decreasing of elements should be done in these cases, also. The element whose value you
should use is the REMOVED element.
The program ends when the sequence has no elements (there are no Pokémons left for Ely to catch).
 */

package Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P9PokemonDontGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> inputList = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> removedValues = new ArrayList<>();

        do {
            int indexController = Integer.parseInt(scanner.nextLine());

            try {
                int valueToRemove = inputList.get(indexController);
                removedValues.add(valueToRemove);
                inputList.remove(indexController);
                for (int i = 0; i < inputList.size(); i++) {
                    int value = inputList.get(i);
                    if (value <= valueToRemove) {
                        inputList.set(i, value + valueToRemove);
                    } else {
                        inputList.set(i, value - valueToRemove);
                    }
                }
            } catch (Exception e) {
                int swapRemovedValue = 0;
                if (indexController < 0) {
                    int firstValue = inputList.get(0);
                    swapRemovedValue = firstValue;
                    inputList.set(0, inputList.get(inputList.size() - 1));

                } else if (indexController >= inputList.size()) {
                    int lastValue = inputList.get(inputList.size() - 1);
                    swapRemovedValue = lastValue;
                    inputList.set(inputList.size() - 1, inputList.get(0));
                }
                removedValues.add(swapRemovedValue);

                for (int i = 0; i < inputList.size(); i++) {
                    int value = inputList.get(i);
                    if (value <= swapRemovedValue) {
                        inputList.set(i, value + swapRemovedValue);
                    } else {
                        inputList.set(i, value - swapRemovedValue);
                    }
                }
            }
        } while (!inputList.isEmpty());
        System.out.println(summer(removedValues));
    }
    static int summer(List<Integer> numbersList){
        int sum = 0;
        for (int number : numbersList){
            sum += number;
        }
        return sum;
    }
}
