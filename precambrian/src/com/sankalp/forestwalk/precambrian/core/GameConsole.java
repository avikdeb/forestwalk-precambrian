package com.sankalp.forestwalk.precambrian.core;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

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
        String name = getConsoleInput();
        System.out.println("Welcome " + name + "!");
        startGame();
    }

    public static void startGame() {
        System.out.println("Welcome to the dangerous forest of Amandelia!");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to enter the river? (Y/N)");
        String ans = scanner.nextLine();
        scanner.close();

        if (ans.equals("Y")) {
            System.out.println("Congratulations! You have moved to the first level");

            Scanner scanner2 = new Scanner(System.in);
            System.out.println("Would you like to enter the cave? (Y/N)");
            String ans2 = scanner2.nextLine();
            scanner2.close();

            if(ans2.equals("Y")) {
                System.out.println("Congratulations! You have moved to the second level");

                Scanner scanner3 = new Scanner(System.in);
                System.out.println("Would you like to enter the maze? (Y/N)");
                String ans3 = scanner3.nextLine();
                scanner3.close();

                if(ans3.equals("Y")) {
                    System.out.println("Congratulations! You have won the game!");
                    System.exit(0);
                }
            }
            else if (ans2.equals("N")) {
                System.out.println("Oops.. you have been crushed by the mountain!");
                System.exit(0);
            } else {
                System.out.println("Wrong answer! Please enter Y or N only");
                System.exit(0);
            }
        }
        else if (ans.equals("N")) {
            System.out.println("Oops.. you have drowned!");
            System.exit(0);
        } else {
            System.out.println("Wrong answer! Please enter Y or N only");
            System.exit(0);
        }
    }
}