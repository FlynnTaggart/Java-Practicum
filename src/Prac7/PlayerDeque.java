package Prac7;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class PlayerDeque implements Player{
    Deque<Integer> deck;
    @Override
    public int getCardFromTop() {
        return deck.removeFirst();
    }

    @Override
    public void putCardsToBottom(Integer[] cards) {
        for (Integer i : cards) {
            deck.addLast(i);
        }
    }

    @Override
    public boolean isEmptyDeck() {
        return deck.size() == 0;
    }

    public PlayerDeque(Integer[] deck) {
        this.deck = new ArrayDeque<Integer>(List.of(deck));
    }
}
