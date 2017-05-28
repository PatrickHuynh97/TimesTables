package com.example.patrick.timestables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class GameView extends AppCompatActivity implements OnClickListener {

    private int difficulty;
    private Button zero, one, two, three, four, five, six, seven, eight, nine, skip, clear;
    private TextView question, answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_view);

        // find and set buttons locally
        zero = (Button) findViewById(R.id.zero);
        one = (Button) findViewById(R.id.one);
        two = (Button) findViewById(R.id.two);
        three = (Button) findViewById(R.id.three);
        four = (Button) findViewById(R.id.four);
        five = (Button) findViewById(R.id.five);
        six = (Button) findViewById(R.id.six);
        seven = (Button) findViewById(R.id.seven);
        eight = (Button) findViewById(R.id.eight);
        nine = (Button) findViewById(R.id.nine);
        skip = (Button) findViewById(R.id.skip);
        clear = (Button) findViewById(R.id.clear);

        zero.setOnClickListener(this);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        clear.setOnClickListener(this);
        skip.setOnClickListener(this);

        // find and set text views locally
        question = (TextView) findViewById(R.id.question);
        answer = (TextView) findViewById(R.id.answer);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.zero:
                answer.append("0");
                break;
            case R.id.one:
                answer.append("1");
                break;
            case R.id.two:
                answer.append("2");
                break;
            case R.id.three:
                answer.append("3");
                break;
            case R.id.four:
                answer.append("4");
                break;
            case R.id.five:
                answer.append("5");
                break;
            case R.id.six:
                answer.append("6");
                break;
            case R.id.seven:
                answer.append("7");
                break;
            case R.id.eight:
                answer.append("8");
                break;
            case R.id.nine:
                answer.append("9");
                break;
            case R.id.clear:
                String current = answer.getText().toString();
                if(current.length()==0){
                    // do nothing if trying to erase nothing
                    System.out.println("Nothing in EditText");
                }
                else {
                    current = current.substring(0, current.length() - 1);
                    answer.setText(current);
                }
                break;
            case R.id.skip:
                answer.setText("");
                break;
        }
    }
}
