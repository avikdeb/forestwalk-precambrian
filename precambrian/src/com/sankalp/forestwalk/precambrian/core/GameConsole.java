package com.sankalp.forestwalk.precambrian.core;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GameConsole {

    private String currentInput;

    private static String welcomeQuestion = "Enter name:";
    private static String welcomeResponse = "Welcome";
    private static String question1 = "Enter choice as mountain side (m) or riverside (r):";
    private static String question_m1 = "Road ends at the cliff. Enter choice if you want to fly (f) or retrun (x):";
    private static String response_m1_pass = "You have reached heaven by your wise choice. Welcome to eternity!";
    private static String response_m1_fail = "You are a coward and kicked-off from the adventure.";

    /**
     * Parameterized class constructor, initialize the class variable
     * currentInput everytime the object is created and sets the current
     * user input to decide the outcome.
     * Private constructor is used to implement Factory Design pattern.
     */
    private GameConsole(String str_input) {
        currentInput = "";
        setCurrentInput(str_input);
    }

    /**
     * Factory method to create object of this Class internally.
     */
    private static GameConsole GameConsoleFactory(String str_input){
        return new GameConsole(str_input);
    }

    /**
     * Returns the user input given in the console.
     */
    public static String getConsoleInput(String str_question) throws Exception {
        String input = "";
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        System.out.println(str_question+"\n ");
        input = br.readLine();
        return input;
    }

    public String getCurrentInput() {
        return currentInput;
    }
    public void setCurrentInput(String currentInput) {
        this.currentInput = currentInput;
    }

    /* Usage: main method */
    public static void main(String[] args) throws Exception {
        //System.out.println("Welcome "+getConsoleInput()+"!");
        GameConsole gameConsole = GameConsoleFactory(getConsoleInput(welcomeQuestion+"\n"));
        System.out.println("Welcome "+gameConsole.getCurrentInput()+"!\n");
        gameConsole = GameConsoleFactory(getConsoleInput(question1+"\n"));
        if(gameConsole.getCurrentInput().equalsIgnoreCase("m")){
            System.out.println("You have chosen mountain side, continue your journey. "+"\n");
            gameConsole = GameConsoleFactory(getConsoleInput(question_m1)+"\n");
            String decision_str = gameConsole.getCurrentInput();
            System.out.println("You have chosen : "+decision_str);
            if (decision_str.equalsIgnoreCase("f")){
                System.out.println("Pass");
                System.out.println(response_m1_pass);
            }
            else if (decision_str.equalsIgnoreCase("x")){
                System.out.println("Fail");
                System.out.println(response_m1_fail);
            }
            else {
                System.out.println("[M] You have chosen an illegal operation, you are kicked out of the adventure. "+"\n");
            }
        } else if (gameConsole.getCurrentInput().equalsIgnoreCase("r")) {
            System.out.println("You have chosen river side, you drowned in the river. "+"\n");
        } else {
            System.out.println("You have chosen an illegal operation, you are kicked out of the adventure. "+"\n");
        }

    }
}