/*
Write a program to append several arrays of numbers.
▪ Arrays are separated by "|".
▪ Values are separated by spaces (" ", one or several).
▪ Order the arrays from the last to the first and their values from left to right.
 */
package Lists;

import java.util.*;
import java.util.stream.Collectors;

public class P7AppendArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> rawArray =
                Arrays.stream(scanner.nextLine().split("\\|"))
                        .collect(Collectors.toList());

        List<List<String>> numberCollection = new ArrayList<>();

        for (String s : rawArray) {
            List<String> rawString = Arrays.stream(s.split(" "))
                    .collect(Collectors.toList());

            while (rawString.contains("")) {
                rawString.remove("");
            }

            while (rawString.contains(" ")) {
                rawString.remove(" ");
            }

            List<String> oneSizeList = Arrays.stream(rawString.toString().replaceAll("[\\[\\],]", "").split(" "))
                    .collect(Collectors.toList());

            numberCollection.add(oneSizeList);
        }

        Collections.reverse(numberCollection);
        for (int i = 0; i < numberCollection.size() - 1; i++){
            String elementToOutput = numberCollection.get(i).toString().replaceAll("[\\[\\],]","");
            if (elementToOutput.equals("")) {
                continue;
            } else {
                System.out.print(numberCollection.get(i).toString().replaceAll("[\\[\\],]","") + " ");
            }
        }
        System.out.print(numberCollection.get(numberCollection.size() - 1).toString().replaceAll("[\\[\\],]",""));
    }
}
