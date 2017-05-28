package com.example.patrick.timestables;

import java.util.ArrayList;
import java.util.Random;
/**
 * Created by Patrick on 24/05/2017.
 * A simple mental math practice application
 */

public class QuestionGenerator {

    // \u00F7 for division sign
    private ArrayList<String> operators = new ArrayList<>();
    private int first,second;
    private String op;
    private String question;
    private int answer;

    public QuestionGenerator(){
        operators.add("+");
        operators.add("-");
        operators.add("/");
        operators.add("*");
    }

    // n = 0: Easy, n = 1: Medium, n=2: Hard
    private void generateQuestion(int n) {
        // choose random operator first
        op = operators.get(new Random().nextInt(operators.size()));

        // depending on operator, difficulty of calculation will change (division/multiplication is harder than addition)
        switch (n) {
            case 0:
                first = (int) (Math.random() * 7 + 1);
                second = (int) (Math.random() * 7 + 1);
                break;

            case 1:
                switch (op) {
                    case "+":
                        first = (int) (Math.random() * 50 + 17);
                        second = (int) (Math.random() * 50 + 17);
                        break;
                    case "-":
                        first = (int) (Math.random() * 50 + 17);
                        second = (int) (Math.random() * 50 + 17);
                        break;
                    default:
                        first = (int) (Math.random() * 10 + 1);
                        second = (int) (Math.random() * 10 + 1);
                        break;
                }
                break;

            case 2:
                switch (op) {
                    case "+":
                        first = (int) (Math.random() * 150 + 40);
                        second = (int) (Math.random() * 150 + 40);
                        break;
                    case "-":
                        first = (int) (Math.random() * 150 + 40);
                        second = (int) (Math.random() * 150 + 40);
                        break;
                    default:
                        first = (int) (Math.random() * 15 + 5);
                        second = (int) (Math.random() * 15 + 5);
                        break;
                }
            break;

        }


        // save answer to the question generated
        switch (op) {
            case "+":
                question = first + " " + op + " " + second;
                answer = first + second;
                break;

            case "-":
                question = first + " " + op + " " + second;
                answer = first - second;
                break;

            // must ensure numbers are divisible
            case "/":
                // find product of random ints
                int product = first * second;
                // question becomes product / second
                question = product + " \u00F7 " + second;
                answer = product / second;
                break;
            case "x":
                question = first + " x " + second;
                answer = first * second;
                break;
        }
    }


    public static void main(String args[]){
        QuestionGenerator questionGenerator = new QuestionGenerator();

        questionGenerator.generateQuestion(0);
        System.out.println("easy question: " + questionGenerator.question + " = " + questionGenerator.answer);

        questionGenerator.generateQuestion(1);
        System.out.println("medium question: " + questionGenerator.question + " = " + questionGenerator.answer);

        questionGenerator.generateQuestion(2);
        System.out.println("hard question: " + questionGenerator.question + " = " + questionGenerator.answer);
    }
}
