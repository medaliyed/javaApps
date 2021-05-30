package com.company.console;

import javafx.beans.binding.When;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * Created by mayedeas on 5/29/2021.
 */
class QandAConsoleTest {

    private  QandAConsole qAndAC;

    @BeforeEach
    public void setUp() throws Exception {
        qAndAC = new QandAConsole();
    }

    @Test
    @DisplayName("q and As splitting")
    public void validateQAndAsFormat() {
        assertEquals(true,qAndAC.validateQAndAsFormat("question? answers"),
                "two elements in a list should work");
        assertEquals(false,qAndAC.validateQAndAsFormat("question answers"),
                "one elements in a list should work");
        assertEquals(false,qAndAC.validateQAndAsFormat("question answers"),
                "one elements in a list should work");
    }

    @Test
    @DisplayName("is correct answers length under 255 character")
    public void isCorrectAnswerLength() {
        List<String> myAnswers = new ArrayList<>();
        myAnswers.add("lalalalalalalala");
        myAnswers.add("tatatatatatatatattata");
        assertEquals(true,qAndAC.isCorrectAnswerLength(myAnswers),
                "two elements in a list should work");

        String repeated = "wrong answer length";
        String sRepeated = IntStream.range(0, 255).mapToObj(i -> repeated).collect(Collectors.joining(""));
        myAnswers.add(sRepeated);
        assertEquals(false,qAndAC.isCorrectAnswerLength(myAnswers),
                "two elements in a list should work");
    }

    @Test
    public void addCorrectQuestionAndAns() {
        String question1 = "question1";
        List<String> answers1 = Arrays.asList("ans1", "ans2", "ans3");
        qAndAC.addCorrectQuestionAndAns(question1,answers1);
        assertEquals(1,qAndAC.qam.size());
        String question2 = "question2";
        List<String> answers2 = Arrays.asList("ans12", "ans22", "ans32");
        qAndAC.addCorrectQuestionAndAns(question2,answers2);
        assertEquals(2,qAndAC.qam.size());
    }


    @Test
    public void searchQuestionandAns() {
        String question1 = "question1";
        String question2 = "question2";
        List<String> answers1 = Arrays.asList("ans1", "ans2", "ans3");
        qAndAC.addCorrectQuestionAndAns(question1,answers1);
        assertNotEquals(null,qAndAC.searchQuestionandAns(question1));
        assertEquals(null,qAndAC.searchQuestionandAns(question2));
    }

/*    @Test
    public void askAQuestion() {
        //qAndAC.askAQuestion();
        *//*InputStream sysInBackup = System.in; // backup System.in to restore it later
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());

        System.setIn(in);
        When(qAndAC.askAQuestion() == "Ask a question:");
        System.setIn(sysInBackup);*//*
        String input = "xvwvwx";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        assertEquals("",qAndAC.askAQuestion(),"sdf");
        System.setIn(in);




    }*/

    /*@Test
    void addLifeQandA() {

    }

    @Test
    void validateQAndAsFormat() {

    }*/

}