package com.example.patrick.timestables;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Random;
/**
 * Created by Patrick on 24/05/2017.
 * A simple mental math practice application
 */

class QuestionGenerator {

    // \u00F7 for division sign
    private ArrayList<String> operators = new ArrayList<>();
    private int first,second;
    private String op;
    private String question;
    private String answer;

    QuestionGenerator(){
        operators.add("+");
        operators.add("-");
        operators.add("/");
        operators.add("*");
    }

    // n = 0: Easy, n = 1: Medium, n=2: Hard
    void generateQuestion(String d) {
        // choose random operator first
        op = operators.get(new Random().nextInt(operators.size()));

        System.out.println("Generating a " + d + " difficulty question");

        // depending on operator, difficulty of calculation will change (division/multiplication is harder than addition)
        switch (d) {
            case "easy":
                switch (op) {
                    case "-":
                        System.out.println("operator to be used is " + op);
                        first = (int) (Math.random() * 7 + 1);
                        second = (int) (Math.random() * 7 + 1);

                        while(first < second) {
                            first = (int) (Math.random() * 7 + 1);
                            second = (int) (Math.random() * 7 + 1);
                        }
                        break;

                    default:
                        System.out.println("operator is not subtraction");
                        first = (int) (Math.random() * 7 + 1);
                        second = (int) (Math.random() * 7 + 1);
                        break;
                }
                break;

            case "medium":
                switch (op) {
                    case "+":
                        System.out.println("operator to be used is " + op);
                        first = (int) (Math.random() * 50 + 17);
                        second = (int) (Math.random() * 50 + 17);
                        break;
                    case "-":
                        System.out.println("operator to be used is " + op);
                        first = (int) (Math.random() * 50 + 17);
                        second = (int) (Math.random() * 50 + 17);

                        while(first < second) second = (int) (Math.random() * 50 + 17);

                        break;
                    case "*":
                        System.out.println("operator to be used is " + op);
                        first = (int) (Math.random() * 12 + 4);
                        second = (int) (Math.random() * 12 + 4);
                        break;
                    default:
                        System.out.println("operator to be used is " + op);
                        first = (int) (Math.random() * 11 + 4);
                        second = (int) (Math.random() * 11 + 3);
                        break;
                }
                break;

            case "hard":
                switch (op) {
                    case "+":
                        System.out.println("operator to be used is " + op);
                        first = (int) (Math.random() * 150 + 40);
                        second = (int) (Math.random() * 150 + 40);
                        break;
                    case "-":
                        System.out.println("operator to be used is " + op);
                        first = (int) (Math.random() * 150 + 40);
                        second = (int) (Math.random() * 150 + 40);

                        System.out.println(first + " < " + second);
                        while (first < second) {
                            second = (int) (Math.random() * 150 + 40);
                        }
                        break;
                    default:
                        System.out.println("operator to be used is " + op);
                        first = (int) (Math.random() * 15 + 7);
                        second = (int) (Math.random() * 15 + 7);
                        break;
                }
                break;

            default:{
                System.out.println("THIS SHOULD NEVER RUN");
                break;
            }
        }

        // save answer to the question generated
        switch (op) {
            case "+":
                System.out.println("Generating answer");
                question = first + " " + op + " " + second;
                int a = first + second;
                answer = Integer.toString(a);
                break;

            case "-":
                question = first + " " + op + " " + second;
                System.out.println("Generating answer");

                int a1 = first - second;
                answer = Integer.toString(a1);
                break;

            // must ensure numbers are divisible
            case "/":
                System.out.println("Generating answer");

                // find product of random ints
                int product = first * second;
                // question becomes product / second
                question = product + " \u00F7 " + second;
                int a2 = product / second;
                answer = Integer.toString(a2);
                break;

            case "*":
                System.out.println("Generating answer");
                question = first + " x " + second;
                int a3 = first * second;
                answer = Integer.toString(a3);
                break;
        }
    }

    String getQuestion(){
        return question;
    }

    String getAnswer(){
        return answer;
    }

}
