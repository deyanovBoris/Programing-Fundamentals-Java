package FundEx2;

import java.util.Scanner;

public class P8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numLoops = Integer.parseInt(scanner.nextLine());
        double minValue = Double.MIN_VALUE;
        String largestKeg = "";

        for (int i = 0; i <numLoops ; i++) {
            String inputName = scanner.nextLine();
            double radius = Double.parseDouble(scanner.nextLine());
            int height = Integer.parseInt(scanner.nextLine());

            double volume = radius*radius*height*Math.PI;
            if (volume > minValue){
                minValue = volume;
                largestKeg = inputName;
            }
        }
        System.out.println(largestKeg);
    }
}
