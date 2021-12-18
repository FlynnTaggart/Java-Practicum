package Prac7;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PlayerQueue implements Player{
    Queue<Integer> deck;
    @Override
    public int getCardFromTop() {
        return deck.remove();
    }

    @Override
    public void putCardsToBottom(Integer[] cards) {
        for (Integer i : cards) {
            deck.add(i);
        }
    }

    @Override
    public boolean isEmptyDeck() {
        return deck.size() == 0;
    }

    public PlayerQueue(Integer[] deck) {
        this.deck = new LinkedList<>(List.of(deck));
    }
}
