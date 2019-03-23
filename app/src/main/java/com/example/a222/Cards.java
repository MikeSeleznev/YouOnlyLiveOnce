package com.example.a222;

import java.lang.reflect.Array;
import java.util.List;


public class Cards {
    private String name;
    private int leftCards;
    private int allcards = 50;
    List<String> quests;

    public Cards(String name, List<String> quests){
        this.name = name;
        this.quests = quests;
    }

    public String getName(){
        return name;
    }

    public int sizeCards(){
        return quests.size();
    }

    public String getQuestion(int num){
        return quests.get(num);
    }
    public void deleteQuest(int num){
        quests.remove(num);

    }
}
