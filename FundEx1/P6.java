package FundEx1;

import java.util.Scanner;

public class P6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String n = scanner.nextLine();
        int lengthN = n.length();
        int sum = 0;

        for (int i = 0; i < lengthN; i++) {
            int digit = Integer.parseInt(n.charAt(i) + "");
            int factorial = 1;
            for (int j = 1; j <= digit; j++) {
                factorial = factorial*j;
            }
            sum += factorial;
        }
        int nInt = Integer.parseInt(n);
        if (nInt == sum){
            System.out.println("yes");
        } else System.out.println("no");
    }
}
