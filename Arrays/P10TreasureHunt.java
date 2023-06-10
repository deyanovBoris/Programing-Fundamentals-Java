package FundEx3;

import java.util.Scanner;

public class P10TreasureHunt
{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String initialChest = scanner.nextLine();
        String command = scanner.nextLine();

        while(!command.equals("Yohoho!")){
            String[] chestArray = initialChest.split("\\|");
            String[] commandArray = command.split(" ");

            switch (commandArray[0]){
                case "Loot":
                    outer:
                    for (int i = 1; i < commandArray.length; i++){
                        for (int j = 0; j < chestArray.length; j++){
                            if (commandArray[i].equals(chestArray[j])){
                                continue outer;
                            }
                        }
                        initialChest = commandArray[i] + "|" + initialChest;
                    }
                    break;

                case "Drop":
                    int index = Integer.parseInt(commandArray[1]);

                    if(index >= 0 && index <= chestArray.length - 1){
                        //Move forward items following item to drop
                        String droppedItem = chestArray[index];
                        for (int i = index; i < chestArray.length - 1; i++){
                            chestArray[i] = chestArray[i + 1];
                        }
                        //Add dropped item to end.
                        chestArray[chestArray.length - 1] = droppedItem;

                        initialChest = String.join("|", chestArray);
                    }
                    break;

                case "Steal":
                    int numberToSteal = Integer.parseInt(commandArray[1]);
                    if (numberToSteal < chestArray.length){
                        String[] stolenItems = new String[numberToSteal];
                        for (int i = chestArray.length - numberToSteal; i < chestArray.length; i++){
                            stolenItems[(i - chestArray.length + numberToSteal)] = chestArray[i];
                        }
                        System.out.println(String.join(", ", stolenItems));

                        String[] notStolen = new String[chestArray.length - numberToSteal];
                        for (int i = 0; i < (chestArray.length - numberToSteal); i++){
                            notStolen[i] = chestArray[i];
                        }

                        initialChest = String.join("|", notStolen);
                    } else {
                        System.out.println(String.join(", ", chestArray));
                        initialChest = "";
                    }
                    break;
            }

            command = scanner.nextLine();
        }
        if (!initialChest.equals("")){
            String[] finalChest = initialChest.split("\\|");
            int stringValues = 0;
            for (String s : finalChest) {
                stringValues += s.length();
            }

            double averagePoints = stringValues/(double) finalChest.length;

            System.out.printf("Average treasure gain: %.2f pirate credits.%n", averagePoints);
        } else {
            System.out.println("Failed treasure hunt.");
        }
    }
}

