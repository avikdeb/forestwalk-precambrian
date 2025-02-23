package com.sankalp.forestwalk.precambrian.core;

public class GameConsole {


    /* Usage: main method */
    public static void main(String[] args) {
        GameLogic gameLogic = new GameLogic();
        try {
            gameLogic.welcomeUser();
            gameLogic.decisionMaker();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}