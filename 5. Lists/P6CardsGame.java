/*
You will be given two hands of cards, which will be integer numbers.
Assume that you have two players.
You must find the winning deck and, respectively, the winner.
You start from the beginning of both hands.
Compare the cards from the first deck to those from the second.
The player, who has a bigger card, takes both cards and puts them on the back of his hand
- the second player's card is last, and the first person's card (the winning one) is before it (second to last),
and the player with the smaller card must remove the card from his deck.
If both players' cards have the same values - no one wins, and the two cards must be removed from the decks.
The game is over when one of the decks is left without any cards.
You have to print the winner on the console and the sum of the left cards: "{First/Second} player wins! Sum: {sum}".
 */
package Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P6CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> playerOneDeck =
                Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        List<Integer> playerTwoDeck =
                Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        while (!(playerTwoDeck.isEmpty() || playerOneDeck.isEmpty())){
            int playerOneCard = playerOneDeck.get(0);
            int playerTwoCard = playerTwoDeck.get(0);

            if (playerOneCard > playerTwoCard) {
                playerOneDeck.add(playerOneCard);
                playerOneDeck.add(playerTwoCard);

                playerOneDeck.remove(0);
                playerTwoDeck.remove(0);
            } else if (playerTwoCard > playerOneCard) {
                playerTwoDeck.add(playerTwoCard);
                playerTwoDeck.add(playerOneCard);

                playerTwoDeck.remove(0);
                playerOneDeck.remove(0);
            } else {
                playerTwoDeck.remove(0);
                playerOneDeck.remove(0);
            }
        }
        if (!playerOneDeck.isEmpty()){
            System.out.printf("First player wins! Sum: %d%n", sumList(playerOneDeck));
        } else {
            System.out.printf("Second player wins! Sum: %d%n", sumList(playerTwoDeck));
        }
    }
    public static int sumList(List<Integer> intList){
        int sum = 0;
        for (int number : intList){
            sum += number;
        }
        return sum;
    }
}
