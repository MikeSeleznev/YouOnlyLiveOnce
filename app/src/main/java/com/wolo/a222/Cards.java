package com.wolo.a222;

import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class Cards {
    private String name;
    private int leftCards;
    private int allcards = 50;
    private List<String> cards;

    public Cards(String name, String[] cards){
        this.name = name;
        this.cards = Arrays.asList(cards);
        this.leftCards = allcards;
    }

    public String getName(){
        return name;
    }

    public int sizeCards(){
        return cards.size();
    }

    public String getRandomQuestion(){
        Random number = new Random();
        int r1 = number.nextInt(leftCards);
        return cards.get(r1);
    }

    public void minusOneCard(){
        leftCards = leftCards - 1;
    }

    public String leftCardsText(){
        StringBuilder str = new StringBuilder();
        str.append("Осталось карт в колоде ");
        str.append(leftCards);
        str.append("/50");

        return str.toString();
    }

    public String leftCardsInt(){
        StringBuilder str = new StringBuilder();
        str.append(leftCards);
        str.append("/50 карт");

        return str.toString();
    }

    public List<String> getCards(){
        return cards;
    }

    public void setLeftCards(){
        leftCards -= 1;
    }
}
