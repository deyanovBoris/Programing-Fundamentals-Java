package FundEx1;

import java.util.Scanner;

public class p10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        double priceSaber = Double.parseDouble(scanner.nextLine());
        double priceRobe = Double.parseDouble(scanner.nextLine());
        double priceBelt = Double.parseDouble(scanner.nextLine());

        int beltsForFree = (students/6);
        double costBelt = priceBelt*students - priceBelt*beltsForFree;
        double costRobe = priceRobe*students;
        double costSaber = priceSaber*Math.ceil(1.1*students);

        double totalPrice = costBelt+costRobe+costSaber;

        if (totalPrice <= budget){
            System.out.printf("The money is enough - it would cost %.2flv.", totalPrice);
        } else {
            System.out.printf("George Lucas will need %.2flv more.", totalPrice-budget);
        }
    }
}
