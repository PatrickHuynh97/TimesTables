package com.example.patrick.timestables;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class GameView extends AppCompatActivity implements OnClickListener {

    private String difficulty;
    private Button zero, one, two, three, four, five, six, seven, eight, nine, skip, clear;
    private TextView question, answer;

    private QuestionGenerator qGen;
    private String q,a;

    private int correct = 0,asked = 0;

    private PopupWindow result;
    private LayoutInflater layoutInflater;
    private LinearLayout resultLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_view);

        Intent intent = getIntent();
        difficulty = intent.getStringExtra("d");

        // find and set buttons/Textviews locally
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

        question = (TextView) findViewById(R.id.question);
        answer = (TextView) findViewById(R.id.answer);

        resultLayout = (LinearLayout) findViewById(R.id.gameViewLayout);

        // initiate questions. Set first question
        qGen = new QuestionGenerator();
        setQuestion();
    }

    private void setQuestion(){
        qGen.generateQuestion(difficulty);

        q = qGen.getQuestion();
        a = qGen.getAnswer();

        question.setText(q);
        answer.setText("");
    }

    // If answer is correct, generate new question. If not, do nothing. User must "skip" if they cannot do the question
    private void checkAnswer(){
        Log.i("GOAL", answer.getText() + " = " + a);

        if (answer.getText().toString().equals(a)){
            Log.i("CORRECT", question.getText() + " = " + answer.getText());
            asked++;
            correct++;

            if(asked == 10){                        // if 10 questions have been asked, end game
                System.out.println("End game. " + correct + "/" + 10 + " correct answers!");
                displayResultWindow();
            }
            else {                                  // else generate new question
                setQuestion();
            }
        }
        else{
            Log.d("INCORRECT ANSWER", "incorrect answer given");
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.zero:
                answer.append("0");
                checkAnswer();
                break;
            case R.id.one:
                answer.append("1");
                checkAnswer();
                break;
            case R.id.two:
                answer.append("2");
                checkAnswer();
                break;
            case R.id.three:
                answer.append("3");
                checkAnswer();
                break;
            case R.id.four:
                answer.append("4");
                checkAnswer();
                break;
            case R.id.five:
                answer.append("5");
                checkAnswer();
                break;
            case R.id.six:
                answer.append("6");
                checkAnswer();
                break;
            case R.id.seven:
                answer.append("7");
                checkAnswer();
                break;
            case R.id.eight:
                answer.append("8");
                checkAnswer();
                break;
            case R.id.nine:
                answer.append("9");
                checkAnswer();
                break;
            case R.id.clear:
                String current = answer.getText().toString();
                if(current.length()==0){
                    // do nothing if trying to erase nothing
                    System.out.println("Nothing to erase");
                }
                else {
                    current = current.substring(0, current.length() - 1);
                    answer.setText(current);
                }
                break;
            case R.id.skip:
                answer.setText("");
                asked++;

                if(asked == 10){                        // if 10 questions have been asked, end game
                    displayResultWindow();
                }
                else {                                  // else generate new question
                    setQuestion();
                }
                break;
        }
    }

    private void displayResultWindow(){
        dimBackground();

        layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
        ViewGroup container =  (ViewGroup) layoutInflater.inflate(R.layout.activity_result_window, null);

        result = new PopupWindow(container, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, true);
        result.showAtLocation(resultLayout, Gravity.CENTER,0,0);


        System.out.println("popupWindow created");

        TextView result = (TextView) container.findViewById(R.id.result);
        Button menu = (Button) container.findViewById(R.id.MainMenu);
        Button restart = (Button) container.findViewById(R.id.TryAgain);

        System.out.println("this should all be done");
        result.setText(correct + "/10");

        menu.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Going back to Main Menu");
                Intent intent = new Intent(GameView.this, MainMenu.class);
                startActivity(intent);
            }
        });

        restart.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameView.this, GameView.class);
                intent.putExtra("d", difficulty);
                startActivity(intent);
            }
        });
    }

    private void dimBackground() {
        layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
        ViewGroup container =  (ViewGroup) layoutInflater.inflate(R.layout.fade_popup, null);

        result = new PopupWindow(container, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, true);
        result.showAtLocation(resultLayout, Gravity.CENTER,0,0);
    }
}
