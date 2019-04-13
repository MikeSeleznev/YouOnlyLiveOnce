package com.wolo.wolo;

import android.app.Activity;
import android.content.Context;

public class PrepareCards extends Activity {
    Cards mCardsUsual;



    public PrepareCards(Context context){
        mCardsUsual = new Cards(Const.USUAL, context.getResources().getStringArray(R.array.usuall));

    }

}
