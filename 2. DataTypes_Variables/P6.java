package FundEx2;

import java.util.Scanner;

public class P6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 97; i <=(97+n-1) ; i++) {
            for (int j = 97; j <=(97+n-1) ; j++) {
                for (int k = 97; k <=(97+n-1) ; k++) {
                    System.out.printf("%c%c%c%n",(char) i, (char) j,(char) k);
                }
            }
        }
    }
}
