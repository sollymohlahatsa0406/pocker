import poker.Card;
import poker.Deck;
import poker.Hand;

public class Poker {
    public static void main(String[] args) {

        Deck deck = new Deck();
        deck.shuffle();

        Hand hand = new Hand();

        Hand cardsHanded = hand.deal(deck);

        String handRank = cardsHanded.evaluateHand();

        System.out.println("\nYour have: " + handRank);



    }
}