package com.csci4020.team7_blackjack;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Pigott on 2/6/2017.
 */

//TODO set up scoring rules.
//TODO set up a YOU WON/YOU LOST dialog.
//TODO set up card counting to prevent duplicates.
//TODO set up dealer switch cases.
//TODO add money to bet along with an amount option.

public class GameActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.blackjack_activity);

    }

    @Override
    public void onClick(View view) {

    }
}
