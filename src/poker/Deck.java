package poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards;

    public Deck() {
        // Initialize the deck with all 52 cards
        this.cards = new ArrayList<>();
        String[] suits = {"♥", "♦", "♣", "♠"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        for (String suit : suits) {
            for (String rank : ranks) {
                Card card = new Card(suit, rank);
                this.cards.add(card);
            }
        }
    }

    public Card dealCard() {
        // Deal the top card from the deck
        if (this.cards.size() == 0) {
            return null;
        }
        return this.cards.remove(0);
    }

    public void shuffle() {
        // Shuffle the cards
        System.out.println("Shuffling ...");
        Collections.shuffle(this.cards);
    }

}
