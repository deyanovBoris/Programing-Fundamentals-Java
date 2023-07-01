/*
Until you receive the "stop" command, you will be given a sequence of strings, each on a new line.
Every odd line on the console represents a resource (e.g., Gold, Silver, Copper, etc.) and every
even - quantity. Your task is to collect the resources and print them on a new line.
Print the resources and their quantities in the format: "{resource} –> {quantity}".
The quantities inputs will be in the range [1 ... 2 000 000 000].
 */

package AssocArrays;

import java.util.*;

public class P2MinerTask
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> items = new LinkedHashMap<>();

        while (true){
            String resource = scanner.nextLine();
            if (resource.equals("stop")){
                break;
            }
            int quantity = Integer.parseInt(scanner.nextLine());

            items.putIfAbsent(resource, 0);
            items.put(resource, items.get(resource) + quantity);
        }

        for(Map.Entry<String, Integer> entry : items.entrySet()){
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
