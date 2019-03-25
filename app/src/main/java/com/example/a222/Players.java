package com.example.a222;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;


public class Players {
    List<String> names;


    public Players(List<String> names){
        this.names = names;
        //TODO do short names
        /*if (names.size()>0){
            for (String s: names) {
                char[] name1 = s.toCharArray();
                shortNames.put(s, Character.toString(name1[0]));
            }
        }*/
    }

    public int numberOfPlayers (){
        return this.names.size();
    }
}
