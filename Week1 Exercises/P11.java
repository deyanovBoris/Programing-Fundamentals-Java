package FundEx1;

import java.util.Scanner;

public class P11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int games = Integer.parseInt(scanner.nextLine());
        double priceHeadset = Double.parseDouble(scanner.nextLine());
        double priceMouse = Double.parseDouble(scanner.nextLine());
        double priceKeyboard = Double.parseDouble(scanner.nextLine());
        double priceDisplay = Double.parseDouble(scanner.nextLine());

        int numberHeadsets = games/2;
        int numberMouse = games/3;
        int numberKeyboard = games/6;
        int numberDisplay = games/12;

        double priceTotal = numberHeadsets*priceHeadset + numberMouse*priceMouse +
                numberKeyboard*priceKeyboard + numberDisplay*priceDisplay;

        System.out.printf("Rage expenses: %.2f lv.", priceTotal);
    }
}
