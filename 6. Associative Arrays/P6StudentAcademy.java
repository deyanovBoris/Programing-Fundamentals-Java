/*
Write a program that keeps the information about students and their grades.
On the first line, you will receive number n. After that, you will receive n pair of rows.
First, you will receive the student's name, after that, you will receive his grade.
Check if the student already exists and if not - add him.
Keep track of all grades for each student.

When you finish reading data, keep students with an average grade higher or equal to 4.50.
Print the students and their average grade in the format:
"{name} –> {averageGrade}"
Format the average grade to the 2nd decimal place.
 */
package AssocArrays;

import java.util.*;

public class P6StudentAcademy
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numStudents = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> studentMap = new LinkedHashMap<>();

        for (int i = 0; i < numStudents; i++){
            String studentName = scanner.nextLine();
            double studentGrade = Double.parseDouble(scanner.nextLine());

            studentMap.putIfAbsent(studentName, new ArrayList<>());
            studentMap.get(studentName).add(studentGrade);
        }

        for (Map.Entry<String, List<Double>> entry : studentMap.entrySet()){
            double average = entry.getValue().stream()
                    .mapToDouble(Double::doubleValue)
                    .average()
                    .getAsDouble();
            if (average >= 4.5){
                System.out.printf("%s -> %.2f%n", entry.getKey(), average);
            }
        }
    }
}
