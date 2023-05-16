package FundEx2;

import java.util.Scanner;

public class P4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int sum = 0;
        for (int i = 0; i < n; i++) {
            int letter = (int) scanner.nextLine().charAt(0);
            sum += letter;
        }
        System.out.printf("The sum equals: %d%n", sum);
    }
}
