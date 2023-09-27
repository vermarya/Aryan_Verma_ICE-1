package card;

import java.util.Random;
import java.util.Scanner;

public class CardTrick {

    public static void main(String[] args) {
        Card[] magicHand = new Card[7];
        Random rand = new Random();

        for (int i = 0; i < magicHand.length; i++) {
            Card c = new Card();
            c.setValue(rand.nextInt(13) + 1);
            c.setSuit(Card.SUITS[rand.nextInt(4)]);
            magicHand[i] = c;
        }

        Card luckCard = new Card();
        luckCard.setValue(2);
        luckCard.setSuit("Clubs");

        Scanner input = new Scanner(System.in);
        System.out.println("Enter a Card Value (1-13 where Ace=1, Jack=11, Queen=12, King=13): ");
        int userValue = input.nextInt();
        System.out.println("Enter a Suit (Hearts, Diamonds, Spades, Clubs): ");
        String userSuit = input.next();

        Card userCard = new Card();
        userCard.setValue(userValue);
        userCard.setSuit(userSuit);

        boolean found = false;
        for (Card card : magicHand) {
            if (card.getValue() == userCard.getValue() && card.getSuit().equalsIgnoreCase(userCard.getSuit())) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Congratulations! The card is in the magic hand!");
        } else {
            System.out.println("Sorry! The card is not in the magic hand!");
        }

        found = false;
        for (Card card : magicHand) {
            if (card.getValue() == luckCard.getValue() && card.getSuit().equalsIgnoreCase(luckCard.getSuit())) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("The luck card is in the magic hand!");
        } else {
            System.out.println("The luck card is not in the magic hand!");
        }

    }
}
