/*
The pirates must safely carry a treasure chest back to the ship, looting along the way.
Create a program that manages the state of the treasure chest along the way.
On the first line, you will receive the initial loot of the treasure chest, a string of items separated by a "|".
"{loot1}|{loot2}|{loot3} ... {lootn}"

The following lines represent commands until "Yohoho!" which ends the treasure hunt:
    • "Loot {item1} {item2}...{itemn}":
        o Pick up treasure loot along the way. Insert the items at the beginning of the chest. 
        o If an item is already contained, don't insert it.
    • "Drop {index}":
        o Remove the loot at the given position and add it to the end of the treasure chest.
        o If the index is invalid, skip the command.
    • "Steal {count}":
        o Someone steals the last count loot items. If there are fewer items than the given count, remove as
          many as there are.
        o Print the stolen items separated by ", ":
            "{item1}, {item2}, {item3} ... {itemn}"
            
In the end, output the average treasure gain, which is the sum of all treasure items length divided by 
the count of all items inside the chest formatted to the second decimal point:

    "Average treasure gain: {averageGain} pirate credits."
If the chest is empty, print the following message: "Failed treasure hunt."
*/

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
            
            //Determining the operation performed using a switch on the first commandArray element.
            switch (commandArray[0]){
                case "Loot":
                    outer:
                    for (int i = 1; i < commandArray.length; i++){
                        for (int j = 0; j < chestArray.length; j++){
                            //If "new" looted item is equal to one of the existing looted items,
                            //continue to next "new" looted item to check
                            if (commandArray[i].equals(chestArray[j])){
                                continue outer;
                            }
                        }
                        //If "new" looted item is not found inside the chest, add it to the front.
                        initialChest = commandArray[i] + "|" + initialChest;
                    }
                    break;

                case "Drop":
                    int index = Integer.parseInt(commandArray[1]);
                    
                    //If the index inputted by the user is invalid, the drop is skipped.
                    if(index >= 0 && index <= chestArray.length - 1){
                        //Move items forward to fill up the space of the dropped item.
                        String droppedItem = chestArray[index];
                        for (int i = index; i < chestArray.length - 1; i++){
                            chestArray[i] = chestArray[i + 1];
                        }
                        //Add dropped item to the end.
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
                        //The else takes care of the situation where the number of items stolen
                        //is more than or equal to the number of itmes inside the chest.
                        
                        System.out.println(String.join(", ", chestArray));
                        initialChest = "";
                    }
                    break;
            }
            //Input the next command.
            command = scanner.nextLine();
        }
        
        //Outside of the while loop we calculate the average pirate points,
        //assuming there are items inside the chest.
        if (!initialChest.equals("")){
            String[] finalChest = initialChest.split("\\|");
            int stringValues = 0;
            for (String s : finalChest) {
                stringValues += s.length();
            }

            double averagePoints = stringValues/(double) finalChest.length;

            System.out.printf("Average treasure gain: %.2f pirate credits.%n", averagePoints);
        } else {
            //No items inside chest - failed.
            System.out.println("Failed treasure hunt.");
        }
    }
}

