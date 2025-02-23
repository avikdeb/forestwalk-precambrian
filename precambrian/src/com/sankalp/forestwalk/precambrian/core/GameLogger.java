package com.sankalp.forestwalk.precambrian.core;

public class GameLogger {

    private String logMessage;

    public GameLogger() {
        logMessage = "";
    }

    public void logger(String str_msg) {
        setLogMessage(str_msg);
        System.out.println(logMessage);
    }

    public String getLogMessage() {
        return logMessage;
    }

    public void setLogMessage(String logMessage) {
        this.logMessage = logMessage;
    }
}
