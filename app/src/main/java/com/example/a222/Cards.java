package com.example.a222;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Random;


public class Cards {
    private String name;
    private int leftCards;
    private int allcards = 50;
    List<String> quests;

    public Cards(String name, List<String> quests){
        this.name = name;
        this.quests = quests;
        this.leftCards = allcards;
    }

    public String getName(){
        return name;
    }

    public int sizeCards(){
        return quests.size();
    }

    public String getRandomQuestion(){
        Random number = new Random();
        int r1 = number.nextInt(leftCards);
        return quests.get(r1);
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
}
