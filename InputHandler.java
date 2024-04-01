/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupproject;

import java.util.Scanner;

/**
 *
 * @author mjhanevich
 */
public class InputHandler {
    private static String lastLine = "";
    private static Scanner scanner = new Scanner(System.in);

    public static String getLine() {
        String line = scanner.nextLine();
        lastLine = line;
        return line;
    }

    public static String getLine(String prompt) {
        System.out.print(prompt);
        String out = getLine();
        return out;
    }

    public static void print(String str) {
        print(str, '\n');
    }

    public static void print(String str, char endChar) {
        System.out.print(str + endChar);
    }

    public static void print(String str, char endChar, char startChar) {
        System.out.print(startChar + str + endChar);
    }

    public static void ProcessCommand(String line) {
        ProcessCommand(line, ' ');
    }

    public static void ProcessCommand(String line, char delimiter) {
        String[] temp = line.split("" + delimiter);
        print("");
        if ("help".equals(temp[0].toLowerCase()) && temp.length == 1) {
            Commands.do_help();
        } else if ("help".equals(temp[0].toLowerCase()) && temp.length > 1) {
            Commands.do_help(temp[1]);
        } else if ("quit".equals(temp[0].toLowerCase())) {
            Commands.do_quit();
        }
    }

    // Getters & Setters
    public static String getLastLine() {
        return lastLine;
    }
}
