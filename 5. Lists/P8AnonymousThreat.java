/*
You will receive a single input line containing STRINGS separated by spaces.
The strings may contain any ASCII character except whitespace.
You will then begin receiving commands in one of the following formats:
• merge {startIndex} {endIndex}
• divide {index} {partitions}
Whenever you receive the merge command, you must merge all elements from the startIndex to the endIndex.
In other words, you should concatenate them.
    Example: {abc, def, ghi} -> merge 0 1 -> {abcdef, ghi}
If any of the given indexes is out of the array, you must take ONLY the range that is INSIDE the array and merge it.
Every time you receive the divide command, you must DIVIDE the element at the given index into several small
substrings with equal length. The count of the substrings should be equal to the given partitions.
    Example: {abcdef, ghi, jkl} -> divide 0 3 -> {ab, cd, ef, ghi, jkl}
If the string CANNOT be exactly divided into the given partitions, make all partitions except the LAST with EQUAL LENGTHS,
 and make the LAST one – the LONGEST.
    Example: {abcd, efgh, ijkl} -> divide 0 3 -> {a, b, cd, efgh, ijkl}
The input ends when you receive the command "3:1". At that point, you must print the resulting elements, joined
by a space.
 */
package Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P8AnonymousThreat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> dataList = Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());

        while (true){
            String command = scanner.nextLine();
            if (command.equals("3:1")){
                break;
            }
            String[] commandArray = command.split(" ");
            String commandSpec = commandArray[0].toLowerCase();
            switch (commandSpec){
                case "merge":
                    int startIndex = Integer.parseInt(commandArray[1]);
                    int endIndex = Integer.parseInt(commandArray[2]);
                    mergeBetweenIndexes(startIndex, endIndex, dataList);
                    break;
                case "divide":
                    int indexToDivide = Integer.parseInt(commandArray[1]);
                    int divideInto = Integer.parseInt(commandArray[2]);
                    divideIndexInto(indexToDivide, divideInto, dataList);
                    break;
            }
        }
        System.out.println(dataList.toString().replaceAll("[\\[\\],]",""));
    }
    //Methods
    public static void mergeBetweenIndexes(int startIndex, int endIndex, List<String> dataList){
        for (int i = startIndex + 1; i <= endIndex; i++){
            try {
                //Try to insert the merged string at the starting index with the one on its right
                dataList.set(startIndex, dataList.get(startIndex) + dataList.get(i));
            } catch(Exception e) {
                //If failed, index is out of bounds wrt list provided
                if (i < 0){
                    //if less than 0, just set i to 0, so i clicks over to 1 after continue and
                    //startIndex to 0 to start fromthe beginning of the list
                    i = 0;
                    startIndex = 0;
                    continue;
                } else if (i >= dataList.size()){
                    //if index provided is throwing an exception but is not smaller than zero,
                    //it must be greater than our list size, so we break
                    //(since startIndex is assumed to be smaller than endIndex)
                    break;
                }
            }
            try {
                //try to delete index we just merged with the startIndex and decrement i
                //due to the list shrinking size.
                dataList.remove(i--);
                endIndex--;
            } catch(Exception j) {
                continue;
            }
        }
    }
    public static void divideIndexInto(int indexToDivide, int divideInto, List<String> dataList){
        List<String> stringToDivide = Arrays
                .stream(dataList.get(indexToDivide).split("|"))
                .collect(Collectors.toList());
        int stringToDivideLength = stringToDivide.size();
        if (divideInto > stringToDivideLength) {
            //if trying to divide a string into more pieces than are available, reset
            //divideInto to the length of the string
            //(can't divide something into more parts than it has)
            divideInto = stringToDivideLength;
        }
        for (int i = indexToDivide; i < indexToDivide + (divideInto - 1); i++){
            //start adding elements from the indexToDivide until the last longer piece
            String result = "";
            for (int j = 0; j < stringToDivideLength/divideInto; j++){
                result += stringToDivide.get(0);
                stringToDivide.remove(0);
            }
            if (i == indexToDivide){
                dataList.add(indexToDivide, result);
                dataList.remove(indexToDivide + 1);
            } else {
                dataList.add(i, result);
            }
        }
        //Add the remaining elements from the list stringToDivide at the end.
        if (divideInto != 1){
            dataList.add(indexToDivide + (divideInto - 1),
                    stringToDivide.toString().replaceAll("[\\[\\],] ",""));
        }
    }
}
