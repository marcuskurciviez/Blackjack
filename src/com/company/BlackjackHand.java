package com.company;

public class BlackjackHand extends Hand {

    public BlackjackHand(){
        super(20);
    }

    public int getValue() {
        int value = 0;

        int numCards = super.getNumCards();

        int countAces = 0;

        for (int i = 0; i < numCards; i++) {
            Card card = super.getCard(i);
            if(card.isAce())
                countAces += 1;
            else {
                if (card.isFaceCard()) {
                    value += 10;
                } else {
                    value += card.getDefaultValue();
                }
            }
        }

        if (countAces > 0) {
            if (countAces > 1) {
                // aces > 1
                int possibleSum = (11 + (countAces - 1));
                // atmost 1 ace can be greater than 1
                if(value + possibleSum <= 21){
                    value += possibleSum;
                } else {
                    value += countAces;
                }
            } else {
                // aces = 1
                if(value + 11 <= 21){
                    value += 11;
                } else {
                    value += 1;
                }
            }
        }

        return value;
    }
}
