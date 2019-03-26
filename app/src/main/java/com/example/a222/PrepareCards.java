package com.example.a222;

import android.app.Activity;
import android.content.Context;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class PrepareCards extends Activity {
    Cards mCardsUsual;



    public PrepareCards(Context context){
        mCardsUsual = new Cards(Const.USUAL, context.getResources().getStringArray(R.array.usuall));

    }

}
