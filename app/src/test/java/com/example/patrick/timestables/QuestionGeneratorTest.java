package com.example.patrick.timestables;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by patrick on 30/05/2017.
 * Tests QuestionGenerator
 */
public class QuestionGeneratorTest {
    @Test
    public void generateQuestion() throws Exception {
        QuestionGenerator questionGenerator = new QuestionGenerator();
        int i = 0;
        while(i < 100) {
            questionGenerator.generateQuestion("easy");
            System.out.println(questionGenerator.getQuestion() + " = " + questionGenerator.getAnswer());
            System.out.println("\n");

            questionGenerator.generateQuestion("medium");
            System.out.println(questionGenerator.getQuestion() + " = " + questionGenerator.getAnswer());
            System.out.println("\n");

            questionGenerator.generateQuestion("hard");
            System.out.println(questionGenerator.getQuestion() + " = " + questionGenerator.getAnswer());
            System.out.println("\n");

            System.out.println(i);
            i++;
        }
    }
}