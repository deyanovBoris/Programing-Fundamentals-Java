package FundEx1;

import java.util.Scanner;

public class P7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        double balance = 0.0;

        while(!input.equals("Start")){
            double inputNum = Double.parseDouble(input);
            switch (input){
                case "0.1":
                case "0.2":
                case "0.5":
                case "1":
                case "2": balance += inputNum;
                    break;
                default: System.out.printf("Cannot accept %.2f%n", inputNum);
            }
            input = scanner.nextLine();
        }

        String selection = scanner.nextLine();

        while(!selection.equals("End")){
            boolean isFailed = false;
            boolean invalidFlag = false;

            switch(selection){
                case "Nuts":
                    if (balance >= 2.0) {
                        balance -= 2.0;
                    } else isFailed = true;
                    break;
                case "Water":
                    if (balance >= 0.7) {
                        balance -= 0.7;
                    } else isFailed = true;
                    break;
                case "Crisps":
                    if (balance >= 1.5) {
                        balance -= 1.5;
                    } else isFailed = true;
                    break;
                case "Soda":
                    if (balance >= 0.8) {
                        balance -= 0.8;
                    } else isFailed = true;
                    break;
                case "Coke":
                    if (balance >= 1.0) {
                        balance -= 1.0;
                    } else isFailed = true;
                    break;
                default:
                    invalidFlag = true;
                    System.out.println("Invalid product");
            }

            if (!isFailed && !invalidFlag) {
                System.out.printf("Purchased %s%n", selection);
            } else if (isFailed) {
                System.out.println("Sorry, not enough money");
            }

            selection = scanner.nextLine();
        }
        System.out.printf("Change: %.2f%n", balance);
    }
}
