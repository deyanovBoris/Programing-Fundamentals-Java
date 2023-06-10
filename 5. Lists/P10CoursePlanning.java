/*
On the first input line, you will receive the initial schedule of lessons and exercises that will be part of the
next course, separated by a comma and space ", ". But before the course starts, there are some changes to be made.
Until you receive "course start", you will be given some commands to modify the course schedule.
The possible commands are:
• Add:{lessonTitle} - add the lesson to the end of the schedule, if it does not exist
• Insert:{lessonTitle}:{index} - insert the lesson to the given index, if it does not exist
• Remove:{lessonTitle} - remove the lesson, if it exists
• Swap:{lessonTitle}:{lessonTitle} - change the place of the two lessons, if they exist
• Exercise:{lessonTitle} - add Exercise in the schedule right after the lesson index, if the lesson exists
    and there is no exercise already, in the following format: "{lessonTitle}-Exercise".
    If the lesson doesn't exist, add the lesson at the end of the course schedule, followed by the Exercise.
Each time you Swap or Remove a lesson, you should do the same with the Exercises, if there are any, which follow the lessons.
 */
package Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P10CoursePlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> inputList = Arrays
                .stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());
        while (true){
            String input = scanner.nextLine();
            if (input.equals("course start")){
                break;
            }
            String[] inputArray = input.split(":");
            String command = inputArray[0];

            switch (command) {
                case "Add" -> adder(inputArray, inputList);
                case "Insert" -> inserter(inputArray, inputList);
                case "Remove" -> remover(inputArray, inputList);
                case "Swap" -> {
                    lessonSwapper(inputArray, inputList);
                    exerciseSwapper(inputList, inputArray[1]);
                    exerciseSwapper(inputList, inputArray[2]);
                }
                case "Exercise" -> exerciser(inputArray, inputList);
            }
        }
        //Print out final list
        for (int index = 0; index < inputList.size(); index++){
            System.out.printf("%d.%s%n", index + 1, inputList.get(index));
        }
    }
    //Methods
    static void adder(String[] inputArray, List<String> inputList){
        String lessonToAdd = inputArray[1];
        if(!inputList.contains(lessonToAdd)){
            inputList.add(lessonToAdd);
        }
    }
    static void inserter(String[] inputArray, List<String> inputList){
        String lessonToInsert = inputArray[1];
        int addAtIndex = Integer.parseInt(inputArray[2]);
        if(!inputList.contains(lessonToInsert)){
            inputList.add(addAtIndex, lessonToInsert);
        }
    }
    static void remover(String[] inputArray, List<String> inputList){
        String lessonToRemove = inputArray[1];
        if(inputList.contains(lessonToRemove)){
            inputList.remove(lessonToRemove);
        }
    }
    static void lessonSwapper(String[] inputArray, List<String> inputList){
        String lessonOneSwap = inputArray[1];
        String lessonTwoSwap = inputArray[2];
        int lessonOneIndex = inputList.indexOf(lessonOneSwap);
        int lessonTwoIndex = inputList.indexOf(lessonTwoSwap);

        if (inputList.contains(lessonOneSwap)
                && inputList.contains(lessonTwoSwap)){
            inputList.set(lessonTwoIndex, lessonOneSwap);
            inputList.set(lessonOneIndex, lessonTwoSwap);
        }
    }
    static void exerciseSwapper(List<String> inputList, String lessonToSwap){
        if (inputList.contains(lessonToSwap + "-Exercise")){
            int lessonIndex = inputList.indexOf(lessonToSwap);
            inputList.remove(lessonToSwap + "-Exercise");
            inputList.add(lessonIndex + 1, lessonToSwap + "-Exercise");
        }
    }
    static void exerciser(String[] inputArray, List<String> inputList){
        String addExerciseTo = inputArray[1];
        if (inputList.contains(addExerciseTo)
                && !inputList.contains(addExerciseTo + "-Exercise")){
            int indexOfLesson = inputList.indexOf(addExerciseTo);
            inputList.add(indexOfLesson + 1, addExerciseTo + "-Exercise");
        } else if (!inputList.contains(addExerciseTo + "-Exercise")){
            inputList.add(addExerciseTo);
            inputList.add(addExerciseTo + "-Exercise");
        }
    }
}
