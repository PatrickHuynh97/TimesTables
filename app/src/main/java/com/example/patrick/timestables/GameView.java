package com.example.patrick.timestables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class GameView extends AppCompatActivity {

    private int difficulty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_view);
    }
}
