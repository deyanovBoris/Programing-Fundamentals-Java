package FundEx3;

import java.util.Scanner;

public class P3ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[] output1 = new String[n];
        String[] output2 = new String[n];
        String[] input = new String[2];

        for (int i = 0; i < n; i++){
            input = scanner.nextLine().split(" ");
            if ((i + 1) % 2 != 0){
                output1[i] = input[0];
                output2[i] = input[1];
            } else {
                output1[i] = input[1];
                output2[i] = input[0];
            }
        }
        System.out.println(String.join(" ", output1));
        System.out.println(String.join(" ", output2));
    }
}
