package Prac7;

import java.util.ArrayList;
import java.util.Arrays;

public class Drunkard {
    ArrayList<Player> players = new ArrayList<>(2);
    int activePlayersCount;
    int stepNumber = 0;
    PlayerType playerType;

    public Drunkard(PlayerType playerType, Integer[] deck) {
        this.playerType = playerType;
        Integer[][] splittedDeck = new Integer[2][deck.length / 2];

        for(int i = 0; i < deck.length; i += deck.length / 2)
            splittedDeck[i / (deck.length / 2)] = Arrays.copyOfRange(deck, i, i + deck.length / 2);

        switch (playerType){
            case STACK:
//                players.add(new PlayerStack(splittedDeck[0]));
//                players.add(new PlayerStack(splittedDeck[1]));
//                break;
            case QUEUE:
                players.add(new PlayerQueue(splittedDeck[0]));
                players.add(new PlayerQueue(splittedDeck[1]));
                break;
            case DEQUE:
                players.add(new PlayerDeque(splittedDeck[0]));
                players.add(new PlayerDeque(splittedDeck[1]));
                break;
        }
        int o = 0;
    }

    public int getStepNumber() {
        return stepNumber;
    }

    int getWinner(){
        if(players.get(0).isEmptyDeck()) return 2;
        else if(players.get(1).isEmptyDeck()) return 1;
        else if(stepNumber >= 106) return -2;
        else return -1;
    }

    void step(){
        stepNumber++;
        Integer[] stepDeck = new Integer[2];
        if(!players.get(0).isEmptyDeck()){
            stepDeck[0] = players.get(0).getCardFromTop();
        }
        if(!players.get(1).isEmptyDeck()){
            stepDeck[1] = players.get(1).getCardFromTop();
        }
        if(stepDeck[0] == 0 && stepDeck[1] == 9)
            players.get(0).putCardsToBottom(stepDeck);
        else if(stepDeck[0] == 9 && stepDeck[1] == 0)
            players.get(1).putCardsToBottom(stepDeck);
        else if(stepDeck[0] > stepDeck[1])
            players.get(0).putCardsToBottom(stepDeck);
        else
            players.get(1).putCardsToBottom(stepDeck);
    }

    int autoPlay(){
        while(true){
            if(getWinner() != -1)
                return getWinner();
            step();
        }
    }
}
