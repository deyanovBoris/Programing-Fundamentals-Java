package FundEx3;

import java.util.Scanner;

/*
You will be given a count of wagons in a train n.
On the next n lines, you will receive how many people will get on that wagon.
In the end, print the whole train and the sum of the people on the train.
*/

public class P1Train {
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
