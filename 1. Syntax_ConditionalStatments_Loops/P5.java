package FundEx1;

import java.util.Scanner;

public class P5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String username = scanner.nextLine();
        int length = username.length();

        String password = "";
        for (int i = length-1; i >= 0; i--){
            password += username.charAt(i) + "";
        }

        int counter = 0;
        do {
            String log = scanner.nextLine();
            if (log.equals(password)) {
                System.out.printf("User %s logged in.", username);
                break;
            } else {
                counter++;
                if(counter < 4){
                System.out.println("Incorrect password. Try again.");
                } else break;
            }
        }while (counter != 4);

        if (counter == 4){
            System.out.printf("User %s blocked!", username);
        }
    }
}
