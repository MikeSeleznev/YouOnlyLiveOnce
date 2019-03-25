package com.example.a222;


import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Map;


public class Game {
    SharedPreferences sPref;
    ArrayList<Cards> cards = new ArrayList<>();
    Players players;


    public Game(ArrayList<String> playersArray, PrepareCards prepareCards){
        Players players = new Players(playersArray);
        this.players = players;
        for (Map.Entry<String, String[]> m: prepareCards.cards.entrySet()){
            cards.add(new Cards(m.getKey(), m.getValue()));
        }

    }

    public void savePreference(Context context){
        Gson gson = new Gson();
        String json = gson.toJson(this);
        sPref = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString("game", json);
        ed.commit();
    }

    public int numberOfPlayers(){
        return  this.players.numberOfPlayers();
    }

    public Players getPlayers(){
        return this.players;
    }
}
