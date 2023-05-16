package FundEx2;

import java.util.Scanner;

public class P3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numPeople = Integer.parseInt(scanner.nextLine());
        int capacity = Integer.parseInt(scanner.nextLine());

        int output = 0;
        if (numPeople < capacity){
            output = 1;
        } else if (numPeople%capacity > 0){
            output = (numPeople/capacity) + 1;
        } else {
            output = (numPeople/capacity);
        }
        System.out.println(output);
    }
}
