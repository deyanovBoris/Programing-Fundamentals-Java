package FundEx2;

import java.util.Scanner;

public class P7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numIter = Integer.parseInt(scanner.nextLine());
        int capacity = 255;
        int totalLiters = 0;
        for (int i = 0; i <numIter; i++) {
            int input = Integer.parseInt(scanner.nextLine());

            if (input>capacity){
                System.out.println("Insufficient capacity!");
            } else {
                capacity -= input;
                totalLiters += input;
            }
        }
        System.out.println(totalLiters);
    }
}
