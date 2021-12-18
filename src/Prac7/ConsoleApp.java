package Prac7;

import java.util.Scanner;

public class ConsoleApp {
    Drunkard drunkard;

    public ConsoleApp(PlayerType playerType) {
        Scanner scanner = new Scanner(System.in);
        Integer[] deck = new Integer[10];
        for(int i = 0; i < deck.length; ++i)
            deck[i] = scanner.nextInt();
        this.drunkard = new Drunkard(playerType, deck);
    }
    void play(){
        switch (drunkard.autoPlay()) {
            case 1 -> System.out.println("first " + drunkard.getStepNumber());
            case 2 -> System.out.println("second " + drunkard.getStepNumber());
            case -2 -> System.out.println("botva");
        }
    }
}
