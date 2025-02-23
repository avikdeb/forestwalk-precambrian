package com.sankalp.forestwalk.precambrian.core;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GameLogic {

    private String currentChoice;
    private GameLogger gameLogger;

    public GameLogic(){
        gameLogger = new GameLogger();
        this.currentChoice = "";
    }

    public void welcomeUser() throws Exception {
        gameLogger.logger(FormatableMessages.MSG_INPUT_NAME);
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        gameLogger.logger(FormatableMessages.MSG_WELCOME+" "+br.readLine()+"!");
    }

    public String getConsoleInput() throws Exception {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        return br.readLine();
    }

    public void decisionMaker() throws Exception {
        String str_decision = "";
        gameLogger.logger(FormatableMessages.MSG_MOUNTAIN_RIVER_CHOICE);
        str_decision = getConsoleInput();
        gameLogger.logger(FormatableMessages.MSG_CONFIRM_CHOICE+" "+str_decision);
        if (str_decision.equalsIgnoreCase("m")){
            gameLogger.logger(FormatableMessages.MSG_MOUNTAIN_LEVEL_UP);
            gameLogger.logger(FormatableMessages.MSG_MOUNTAIN_FLY_CHOICE);
            str_decision = getConsoleInput();
            gameLogger.logger(FormatableMessages.MSG_CONFIRM_CHOICE+" "+str_decision);
            if (str_decision.equalsIgnoreCase("f")){
                gameLogger.logger(FormatableMessages.MSG_MOUNTAIN_FLY);
            } else if (str_decision.equalsIgnoreCase("r")) {
                gameLogger.logger(FormatableMessages.MSG_FAILURE);
            } else if (str_decision.equalsIgnoreCase("z")) {
                gameLogger.logger(FormatableMessages.MSG_WINNING);
            } else {
                gameLogger.logger(FormatableMessages.MSG_ILLEGAL);
            }
        } else if (str_decision.equalsIgnoreCase("r")) {
            gameLogger.logger(FormatableMessages.MSG_RIVER_LEVEL_UP);
            gameLogger.logger(FormatableMessages.MSG_RIVER_SWIM_CHOICE);
            str_decision = getConsoleInput();
            gameLogger.logger(FormatableMessages.MSG_CONFIRM_CHOICE+" "+str_decision);
            if (str_decision.equalsIgnoreCase("s")){
                gameLogger.logger(FormatableMessages.MSG_RIVER_SWIM);
            } else if (str_decision.equalsIgnoreCase("r")) {
                gameLogger.logger(FormatableMessages.MSG_FAILURE);
            } else if (str_decision.equalsIgnoreCase("z")) {
                gameLogger.logger(FormatableMessages.MSG_WINNING);
            } else {
                gameLogger.logger(FormatableMessages.MSG_ILLEGAL);
            }
        } else {
            gameLogger.logger(FormatableMessages.MSG_ILLEGAL);
        }
    }
}
