package com.sankalp.forestwalk.precambrian.core;

import com.sankalp.forestwalk.precambrian.userdata.UserData;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GameLogic {

    private String currentChoice;
    private GameLogger gameLogger;
    private String user;

    /*
     * Usage : Class constructor, initializes class variables.
     */
    public GameLogic(){
        gameLogger = new GameLogger();
        this.currentChoice = "";
        this.user = "";
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    /*
     * Usage : Method to capture and display user name.
     */
    public void welcomeUser() throws Exception {
        gameLogger.logger(FormatableMessages.MSG_INPUT_NAME);
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String username = br.readLine();
        gameLogger.logger(FormatableMessages.MSG_WELCOME+" "+username+"!");
        setUser(username);
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
        UserData userData = new UserData();

        userData.addChoices(str_decision);
        if (str_decision.equalsIgnoreCase("m")){
            gameLogger.logger(FormatableMessages.MSG_MOUNTAIN_LEVEL_UP);
            gameLogger.logger(FormatableMessages.MSG_MOUNTAIN_FLY_CHOICE);
            str_decision = getConsoleInput();
            gameLogger.logger(FormatableMessages.MSG_CONFIRM_CHOICE+" "+str_decision);
            userData.addChoices(str_decision);
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
            userData.addChoices(str_decision);
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
        //gameLogger.logger("[INFO] List of User commands issued : "+userData.getUserChoiceList());
        userData.writeUserChoiceFie(getUser(), userData.getUserChoiceList().toString());
    }
}
