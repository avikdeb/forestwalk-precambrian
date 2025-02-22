package com.sankalp.forestwalk.precambrian.core;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GameConsole {

    /* Usage: Method to take user inputs from console using BufferedReader */
    public static String getConsoleInput() throws Exception {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        System.out.println("Enter your name :\n ");
        return br.readLine();
    }

    /* Usage: main method */
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome "+getConsoleInput()+"!");
    }
}
