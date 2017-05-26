package com.example.patrick.timestables;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;
import android.view.View.OnClickListener;


public class MainMenu extends AppCompatActivity implements OnClickListener{
    Button easy, medium, hard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        easy = (Button)findViewById(R.id.EasyMode);
        medium = (Button)findViewById(R.id.MediumMode);
        hard = (Button)findViewById(R.id.HardMode);

        easy.setOnClickListener(this);
        medium.setOnClickListener(this);
        hard.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.EasyMode:
                Log.d("MR.bool", "Button1 was clicked ");
                Intent intent = new Intent(MainMenu.this, GameView.class);
                intent.putExtra("d", 0);
                startActivity(intent);
                break;

            case R.id.MediumMode:
                Log.d("MR.bool", "Button2 was clicked ");
                Intent intent1 = new Intent(MainMenu.this, GameView.class);
                intent1.putExtra("d", 1);
                startActivity(intent1);
                break;

            case R.id.HardMode:
                Log.d("MR.bool", "Button2 was clicked ");
                Intent intent2 = new Intent(MainMenu.this, GameView.class);
                intent2.putExtra("d", 2);
                startActivity(intent2);
                break;

            default:

                break;
        }
    }

}
