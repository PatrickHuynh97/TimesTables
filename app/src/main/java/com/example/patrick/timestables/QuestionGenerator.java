package com.example.patrick.timestables;

import java.util.ArrayList;
import java.util.Random;
/**
 * Created by Patrick on 24/05/2017.
 */

public class QuestionGenerator {

    // \u00F7 for division sign
    private ArrayList<String> operators = new ArrayList<>();
    private int first,second;
    private String op;
    public String question;

    public QuestionGenerator(){
        operators.add("+");
        operators.add("-");
        operators.add("/");
        operators.add("*");
    }

    // n = 0: Easy, n = 1: Medium, n=2: Hard
    private int generateQuestion(int n){
        // choose random operator first
        op = operators.get(new Random().nextInt(operators.size()));

        // depending on operator, difficulty of calculation will change (division is harder than addition)
        if(n==0) {
            first = (int) (Math.random() * 7 + 1);
            second = (int) (Math.random() * 7 + 1);
        }
        else if(n==1){
            if(op == "+") {
                first = (int) (Math.random() * 50 + 17);
                second = (int) (Math.random() * 50 + 17);
            }
            else if(op == "-") {
                first = (int) (Math.random() * 50 + 17);
                second = (int) (Math.random() * 50 + 17);
            }
            else{
                first = (int) (Math.random() * 10 + 1);
                second = (int) (Math.random() * 10 + 1);
            }
        }
        else if(n==2) {
            if(op == "+") {
                first = (int) (Math.random() * 150 + 40);
                second = (int) (Math.random() * 150 + 40);
            }
            else if(op == "-") {
                first = (int) (Math.random() * 150 + 40);
                second = (int) (Math.random() * 150 + 40);
            }
            else{
                first = (int) (Math.random() * 15 + 5);
                second = (int) (Math.random() * 15 + 5);
            }
        }


        // return answer to the question generated
        if(op == "+"){

            question = first + " " +  op + " " + second;
            return first + second;
        }
        if(op == "-") {
            question = first + " " + op + " " + second;
            return first - second;
        }
        // must ensure numbers are divisible
        if(op == "/") {
            // find product of random ints
            int product = first * second;
            // question becomes product / second
            question = product + " \u00F7 " + second;
            return product / second;
        }
        else {
            question = first + " x " + second;
            return first*second;
        }
    }

    public static void main(String args[]){
        QuestionGenerator questionGenerator = new QuestionGenerator();
        System.out.println("easy question: " + questionGenerator.generateQuestion(0) + " = " + questionGenerator.question);
        System.out.println("medium question: " + questionGenerator.generateQuestion(1) + " = " + questionGenerator.question);
        System.out.println("hard question: " + questionGenerator.generateQuestion(2) + " = " + questionGenerator.question);

    }
}
