/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupproject;

/**
 * General Tester Class to allow convenient access to all other classes in the
 * project.
 * @author mjhanevich
 */
public class Tester {
    
    public static Cart mostRecentCart;
    // public static Receipt mostRecentReceipt;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // SETUP
        
        // Initializes the Command Data for help command
        Commands.Initialize();
        
        // Loops looking for input
        // Only way out is the "Quit" command at the moment
        while (true) {
            InputLoop();
        }
    }
    
    private static void InputLoop() {
        String in = InputHandler.getLine("What do you want to do?\n::");
        InputHandler.ProcessCommand(in);
    }
    
}
