package FundEx1;

import java.util.Scanner;

public class P9 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numOrders = Integer.parseInt(scanner.nextLine());
        double total = 0;

        for (int i = 0; i < numOrders; i++) {
            double pricePerCap = Double.parseDouble(scanner.nextLine());
            int days = Integer.parseInt(scanner.nextLine());
            int capsules = Integer.parseInt(scanner.nextLine());

            double price = pricePerCap*days*capsules;
            total += price;
            System.out.printf("The price for the coffee is: $%.2f%n", price);
        }
        System.out.printf("Total: $%.2f%n", total);
    }
}
