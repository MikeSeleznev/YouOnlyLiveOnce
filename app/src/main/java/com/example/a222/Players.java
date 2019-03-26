package com.example.a222;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;


public class Players {
    private String names;


    /*public Players(List<String> names){
        this.names = names;
        //TODO do short names
        /*if (names.size()>0){
            for (String s: names) {
                char[] name1 = s.toCharArray();
                shortNames.put(s, Character.toString(name1[0]));
            }
        }*/


    public Players(String names){
        this.names = names;}

    public int numberOfPlayers (){
        return this.names.length();
    }

    public String getShortName(){
        char[] name1 = this.names.toCharArray();
        return Character.toString(name1[0]);
    }

    public String getFullName(){
        return names;
    }
}
