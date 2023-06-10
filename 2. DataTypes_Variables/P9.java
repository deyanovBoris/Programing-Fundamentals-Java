package FundEx2;

import java.util.Scanner;

public class P9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startYield = Integer.parseInt(scanner.nextLine());
        int miningDays = 0;
        int collected = 0;

        while (startYield >= 100){
            miningDays++;
            collected += startYield-26;
            startYield -= 10;
        }
        if (collected >= 26) {
            collected -= 26;
        } else collected = 0;

        System.out.printf("%d%n%d%n", miningDays, collected);
    }
}
