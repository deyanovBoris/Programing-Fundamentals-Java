package FundEx2;

import java.util.Scanner;

public class P10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int pokePower = Integer.parseInt(scanner.nextLine());
        int originalPokePower = pokePower;
        int distance = Integer.parseInt(scanner.nextLine());
        int exhaustionFactor = Integer.parseInt(scanner.nextLine());

        int targets = 0;

        while(pokePower >= distance){
            pokePower -= distance;
            targets++;

            if (pokePower == (originalPokePower/(double) 2) && exhaustionFactor != 0){
                pokePower = pokePower/exhaustionFactor;
            }
        }
        System.out.println(pokePower);
        System.out.println(targets);
    }
}
