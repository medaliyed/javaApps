package com.company.console;

import com.company.manager.LifeQandAManager;
import com.company.entities.QuestionAndAnswers;

import java.util.*;

public class QandAConsole {


    public LifeQandAManager qam;
    private Scanner sc;
    private String[] qAndAStr;
    private char bulletSymbol='\u2022';
    public QandAConsole() {

        this.qam = new LifeQandAManager();
        this.sc = new Scanner(System.in);

    }

    public int menu() {
        System.out.println();
        System.out.println("#####################################################################################");
        System.out.println("\t\t\t\t\t------Life Questions and Answers menu------");
        System.out.println("\t\t\t\t\t\t\t1: Add questions and answers");
        System.out.println("\t\t\t\t\t\t\t2: Ask a life question");
        System.out.println("\t\t\t\t\t\t\t0: Exit");
        System.out.println("#####################################################################################");
        int choice = readUserChoice(0, 3);

        return choice;

    }

    public void start() {
        while (true) {
            int choice = menu();
            switch (choice) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    addLifeQandA();
                    break;
                case 2:
                    askAQuestion();
                    break;

                default:
                    System.out.println("PLEASE SELECT A VALUE FROM THE MENU");
                    break;
            }

        }
    }

    public void askAQuestion() {
        System.out.println("Ask a question:");
        String questionsAboutLife = sc.nextLine();
        //extra space after and before the question is deleted
        Set<String> answersList = findQAndAnswers(questionsAboutLife.trim());
        if(answersList == null){
            System.out.println("\t\t\t\t\t\t\t\t"+bulletSymbol+" The answer to life, universe and everything is 42");
        }else {
            System.out.println("\t\t\t\t"+bulletSymbol+" The answers are:");
            answersList.stream().forEach(s -> System.out.println("\t\t\t\t\t\t\t\t"+bulletSymbol + s));
        }

    }

    public Set<String> findQAndAnswers(String questionsAboutLife) {

        QuestionAndAnswers answers = qam.stream()
                .filter(question -> questionsAboutLife.equals(question.getQuestion()))
                .findAny()
                .orElse(null);
        if(answers != null){
            return answers.getAnswers();
        }
         return null;
    }


    public int readUserChoice(int min, int max) {
        int choice;
        while (true) {
            try {
                choice = Integer.parseInt(sc.nextLine());
                if (choice >= min && choice <= max) {
                    break;
                } else {
                    System.out.println("PLEASE SELECT A VALUE FROM THE MENU");
                }
            } catch (Exception e) {
                System.out.println("PLEASE ENTER A NUMBER");
            }
        }
        return choice;
    }

    public void addLifeQandA() {
        boolean correctAnswerLenght = true;
        System.out.println("Please enter the Life question and answers in the following format:");
        System.out.println("<question>? “<answer1>” “<answer2>” “<answerX>”");
        System.out.println("Please enter note a question or any answer should not exceed 255 character:");
        String questionsAndAnswers = sc.nextLine();

        boolean isValid = validateQAndAsFormat(questionsAndAnswers);
        if (isValid) {
            qAndAStr = questionsAndAnswers.split("\\?", 2);
            String theQuestion = qAndAStr[0].trim().concat("?");
            List<String> theAnswers = Arrays.asList(qAndAStr[1].trim().substring(1, qAndAStr[1].length()-2).split("\\” +\\“"));
            correctAnswerLenght = isCorrectAnswerLength(theAnswers);
            //My idea here is to update a question with more answers if are not already in the set
            if (correctAnswerLenght == true) {
                QuestionAndAnswers isExistingQuestion = searchQuestionandAns(theQuestion);

                if(isExistingQuestion != null){
                    System.out.println("Updating answers of an existing question:");
                    isExistingQuestion.getAnswers().addAll(theAnswers);
                }else {
                    addCorrectQuestionAndAns(theQuestion, theAnswers);
                }
            }

        } else {
            System.out.println("");
            System.out.println("Please Enter a valid question and answer format: <question>? “<answer1>” “<answer2>” “<answerX>”");
            System.out.println("");
        }

    }

    public QuestionAndAnswers searchQuestionandAns(String theQuestion) {
        QuestionAndAnswers theQandAinTheSet = this.qam.stream()
                .filter(qanda -> theQuestion.equals(qanda.getQuestion()))
                .findAny()
                .orElse(null);

        return theQandAinTheSet;
    }

    public boolean isCorrectAnswerLength(List<String> theAnswers) {
        boolean correctAnswerLenght = true;
        for (int i = 0; i < theAnswers.size(); i++) {
            if (theAnswers.get(i).length() > 255) {
                System.out.println("The answer number " + ++i + " has exceeded 255 character please fix it !");
                correctAnswerLenght = false;
                break;
            }
        }
        return correctAnswerLenght;
    }

    public void addCorrectQuestionAndAns(String theQuestion, List<String> theAnswers) {
        Set<String> answersSet = new HashSet<>(theAnswers);

        QuestionAndAnswers qAndAs = new QuestionAndAnswers();
        qAndAs.setQuestion(theQuestion);
        qAndAs.setAnswers(answersSet);
        this.qam.addLifeQandA(qAndAs);
        System.out.println("question and answers added successfully");
        /*System.out.println(this.qam.size());*/
    }

    public boolean validateQAndAsFormat(String questionsAndAnswers) {
        return questionsAndAnswers.split("\\? ", 2).length == 2;

    }

}