package FundEx2;

import java.util.Scanner;

public class P11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());
        double minInt = Double.MIN_VALUE;

        int winningSnow = 0;
        int winningTime = 0;
        int winningQuality = 0;

        for (int i = 0; i < N; i++) {
            int snowballSnow = Integer.parseInt(scanner.nextLine());
            int snowballTime = Integer.parseInt(scanner.nextLine());
            int snowballQuality = Integer.parseInt(scanner.nextLine());

            double snowballValue = Math.pow((snowballSnow/ snowballTime), snowballQuality);
            if (snowballValue > minInt){
                minInt = snowballValue;

                winningSnow = snowballSnow;
                winningTime = snowballTime;
                winningQuality = snowballQuality;
            }
        }
        System.out.printf("%d : %d = %.0f (%d)%n", winningSnow, winningTime, minInt, winningQuality);
    }
}
