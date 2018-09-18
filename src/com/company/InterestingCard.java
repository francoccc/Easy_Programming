package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class InterestingCard {
    private int n;
    private ArrayList<Card> cards = new ArrayList<>();

    private class Card{
        int s_1;
        int s_2;

        Card(int s_1, int s_2){
            this.s_1 = s_1;
            this.s_2 = s_2;
        }
    }

    public InterestingCard() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        while (n-- > 0) {
            cards.add(new Card(sc.nextInt(), sc.nextInt()));
        }
        run();
    }

    private void run(){

    }
}
