package poker;

import java.util.*;

public class Hand {
    private List<Card> cards;

    public Hand() {
        // Initialize an empty hand
        this.cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        // Add a card to the hand
        this.cards.add(card);
    }

    public String evaluateHand() {
        // Determine the rank of the hand based on its cards
        if (hasFlush() && hasStraight()) {
            return "Straight Flush";
        }
        else if (hasFourOfAKind()) {
            return "Four of a Kind";
        }
        else if (hasFullHouse()) {
            return "Full House";
        }
        else if (hasFlush()) {
            return "Flush";
        }
        else if (hasStraight()) {
            return "Straight";
        }
        else if (hasThreeOfAKind()) {
            return "Three of a Kind";
        }
        else if (hasTwoPairs()) {
            return "Two Pairs";
        }
        else if (hasPair()) {
            return "Pair";
        }
        else {
            return "High Card";
        }
    }
    private boolean hasFlush() {
        String suit = cards.get(0).getSuit();
        for (Card card : cards) {
            if (!card.getSuit().equals(suit)) {
                return false;
            }
        }
        return true;
    }
    private boolean hasStraight() {
        List<Integer> ranks = new ArrayList<>();
        for (Card card : cards) {
            ranks.add(getRankValue(card.getRank()));
        }
        Collections.sort(ranks);
        if (ranks.get(4) - ranks.get(0) == 4) {
            return true;
        }
        // Special case for A-5 straight
        else if (ranks.get(0) == 2 && ranks.get(1) == 3 && ranks.get(2) == 4 && ranks.get(3) == 5 && ranks.get(4) == 14) {
            return true;
        }
        else {
            return false;
        }
    }
    private boolean hasFourOfAKind() {
        return hasNOfAKind(4);
    }
    private boolean hasFullHouse() {
        List<Integer> ranks = new ArrayList<>();
        for (Card card : cards) {
            ranks.add(getRankValue(card.getRank()));
        }
        Collections.sort(ranks);
        if ((ranks.get(0) == ranks.get(1) && ranks.get(2) == ranks.get(4)) || (ranks.get(0) == ranks.get(2) && ranks.get(3) == ranks.get(4))) {
            return true;
        }
        else {
            return false;
        }
    }
    private boolean hasThreeOfAKind() {
        return hasNOfAKind(3);
    }
    private boolean hasTwoPairs() {
        List<Integer> ranks = new ArrayList<>();
        for (Card card : cards) {
            ranks.add(getRankValue(card.getRank()));
        }
        Collections.sort(ranks);
        if ((ranks.get(0) == ranks.get(1) && ranks.get(2) == ranks.get(3)) || (ranks.get(1) == ranks.get(2) && ranks.get(3) == ranks.get(4)) || (ranks.get(0) == ranks.get(1) && ranks.get(3) == ranks.get(4))) {
            return true;
        }
        else {
            return false;
        }
    }
    private boolean hasPair() {
        return hasNOfAKind(2);
    }
    private boolean hasNOfAKind(int n) {
        Map<Integer, Integer> rankCount = new HashMap<>();
        for (Card card : cards) {
            int rankValue = getRankValue(card.getRank());
            rankCount.put(rankValue, rankCount.getOrDefault(rankValue, 0) + 1);
        }
        for (int count : rankCount.values()) {
            if (count == n) {
                return true;
            }
        }
        return false;
    }
    private int getRankValue(String rank) {
        if (rank.equals("A")) {
            return 14;
        }
        else if (rank.equals("K")) {
            return 13;
        }
        else if (rank.equals("Q")) {
            return 12;
        }
        else if (rank.equals("J")) {
            return 11;
        }
        else {
            return Integer.parseInt(rank);
        }
    }
    public Hand deal(Deck deck){
        Hand hand = new Hand();

        System.out.print("You hand: ");
        for (int i = 0; i < 5; i++) {
            Card card = deck.dealCard();
            hand.addCard(card);
            System.out.print(card.toString() + " ");
        }
        return hand;
    }

}
