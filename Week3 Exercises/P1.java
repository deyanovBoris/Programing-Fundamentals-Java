package FundEx3;

import java.util.Scanner;

public class P1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        int[] numberPassangers = new int[n];

        for (int i = 0; i < n; i++){
            int passangers = Integer.parseInt(scanner.nextLine());

            numberPassangers[i] = passangers;
            sum += passangers;
        }

        for(int x : numberPassangers){
            System.out.print(x + " ");
        }

        System.out.printf("%n%d", sum);
    }
}