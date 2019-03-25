package com.example.a222;

import android.app.Activity;
import android.content.Context;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class PrepareCards extends Activity {
    Map<String, String[]> cards;


    public PrepareCards(Context context){
        cards = new
        cards.put(Const.USUAL, context.getResources().getStringArray(R.array.usuall));
    }

    public Map<String, String[]> getCards(){
        return this.cards;
    }
}
