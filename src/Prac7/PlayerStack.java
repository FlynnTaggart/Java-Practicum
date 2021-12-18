package Prac7;

import java.util.Arrays;
import java.util.Stack;

public class PlayerStack implements Player{
    Stack<Integer> deck0;
    Stack<Integer> deck1;
    byte deckIndex = 0;
    @Override
    public int getCardFromTop() {
        return deck0.pop();
    }

    @Override
    public void putCardsToBottom(Integer[] cards) {
        for (Integer i : cards) {
            deck1.add(i);
        }
    }

    @Override
    public boolean isEmptyDeck() {
        if(deck0.isEmpty()) {
            while(!deck1.isEmpty()){
                deck0.push(deck1.pop());
            }
        }
        return deck0.isEmpty();
    }

    public PlayerStack(Integer[] deck) {
        this.deck0 = new Stack<>();
        this.deck1 = new Stack<>();
        this.deck0.addAll(Arrays.asList(deck));
    }
}
