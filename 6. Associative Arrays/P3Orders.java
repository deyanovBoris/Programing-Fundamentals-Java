/*
Write a program which keeps the information about products and their prices.
Each product has a name, a price, and its quantity.

If the product doesn't exist yet, add it with its starting quantity.

If you receive a product that already exists, increases its quantity by the input
quantity and if its price is different, replace the price as well.

You will receive products' names, prices, and quantities on new lines.

Until you receive the command "buy", keep adding items.
When you do receive the command "buy", print the items with their names and the
total price of all the products with that name.

 */
package AssocArrays;

import java.util.*;

public class P3Orders
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<Double>> items = new LinkedHashMap<>();

        while (true){
            String input = scanner.nextLine();
            if (input.equals("buy")){
                break;
            }
            String[] inputArray = input.split(" ");
            String item = inputArray[0];
            double price = Double.parseDouble(inputArray[1]);
            double quantity = Double.parseDouble(inputArray[2]);

            if(!items.containsKey(item)){
                items.put(item, new ArrayList<>());
                items.get(item).add(price);
                items.get(item).add(quantity);
            } else {
                items.get(item).set(0, price);
                items.get(item).set(1, items.get(item).get(1) + quantity);
            }
        }

        for(Map.Entry<String, List<Double>> entry : items.entrySet()){
            double priceEnd = 1.0;
            //calculating final price -> price*quantity
            for (Double value : entry.getValue()){
                priceEnd *= value;
            }
            System.out.printf("%s -> %.2f%n", entry.getKey(), priceEnd);
        }
    }
}
