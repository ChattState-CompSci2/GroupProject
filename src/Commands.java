<<<<<<< Updated upstream:Commands.java
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupproject;

import java.util.EnumMap;
import java.util.Map;

/**
 *
 * @author mjhanevich
 */
public class Commands {
    
    private static Map<CommandNames, String> CommandData = new EnumMap<CommandNames, String>(CommandNames.class);
    
    /**
     * enumerated type that provides all implemented Command Types to all classes in package.
     */
    public enum CommandNames {

        /**
         * Lists all commands and their use cases
         * Can add a String after to search command list
         */
        HELP,

        /**
         * Begins a basic Checkout operation
         * Can add flags after for more detailed operation
         */
        CHECKOUT,

        /**
         * "Prints" a receipt
         */
        RECEIPT,

        /**
         * NOT IMPLEMENTED YET.
         * Searches for a specific item
         */
        LOOKUP,
        
        /**
         * Displays your current cart
         */
        CART,

        /**
         * Quits the application.
         */
        QUIT
    }

    /**
     * Initializes all Command Data for reference in the help command.
     * Should not be run more than once.
     */

    public static void Initialize() {
        CommandData.put(CommandNames.HELP, "HELP\n├Lists all commands and their use cases\n│└Syntax: Help\n└Looks up documentation for a specific command\n ├Syntax: Help [command]\n └Commands: [Any valid command name]");
        CommandData.put(CommandNames.CHECKOUT, "CHECKOUT\n└Begins a basic Checkout operation\n └Syntax: Checkout [Flags]\n  └Flags: [\"-d\": debug, \"-q\": quick test]\n   ├debug: \"Enables debug text and messages\"\n   └quick test: \"Instead of taking user input, runs a predefined routine for easy testing\"");
        CommandData.put(CommandNames.RECEIPT, "RECEIPT\n└\"Prints\" a receipt of latest checkout operation\n └Syntax: Receipt");
        CommandData.put(CommandNames.CART, "CART\n└Displays all items in user's cart\n └Syntax: Cart");
        CommandData.put(CommandNames.QUIT, "QUIT\n└Quits the application\n └Syntax: Quit");
    }
    
    /**
     * Lists all commands and their use cases.
     */
    public static void do_help() {
        // Loops through the Command Data map until the end
        // Prints provided information for each Command
        CommandData.entrySet().forEach((entry) -> {
            System.out.println(entry.getValue() + "\n");
        });
    }
    
    /**
     * Lists all commands and their use cases.
     * @param command Accepts a String to search command names for specifically.
     */
    public static void do_help(String command) {
        // Loops through the Command Data map until the end
        // If the name contains the searched for String, prints the Command info
        CommandData.entrySet().forEach((entry) -> {
            if (entry.getKey().name().contains(command)) {
                System.out.println(entry.getValue() + "\n");
            }
        });
    }
    
    /**
     * Begins a basic Checkout operation.
     * @param args Accepts an Array of Strings representing requested flags.
     */
    public static void do_checkout(String[] args) {
        // Setup flags
        boolean flagDebug = false;
        boolean flagQuickTest = false;
        if (args.length > 0) {
            for (String arg : args) {
                switch (arg) {
                    case "-d":
                        flagDebug = true;
                        break;
                    case "-q":
                        flagQuickTest = true;
                        break;
                }
            }
        }
        
        // Code for checkout goes here OR reference to where it was created
    }
    
    /**
     * NOT IMPLEMENTED YET.
     * Prints out the user's receipt.
     */
    public static void do_receipt() {
        // This command will be implemented by someone else,
        //  then either connected to here or referenced here
    }
    
    /**
     * Prints the toString method of the most recent Cart object.
     */
    public static void do_cart() {
        if (Tester.mostRecentCart != null) {
            System.out.println(Tester.mostRecentCart.toString());
        }
    }

    /**
     * Quits the application with an exit code of 0.
     */
    public static void do_quit() {
        InputHandler.print("Goodbye!");
        System.exit(0);
    }
    
    /**
     * Quits the application.
     * @param exitCode Forces the exit to have this as its exit code.
     */
    public static void do_quit(int exitCode) {
        InputHandler.print("Goodbye!");
        System.exit(exitCode);
    }
}
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.EnumMap;
import java.util.Map;

/**
 *
 * @author mjhanevich
 */
public class Commands {
    
    private static Map<CommandNames, String> CommandData = new EnumMap<CommandNames, String>(CommandNames.class);
    
    /**
     * enumerated type that provides all implemented Command Types to all classes in package.
     */
    public enum CommandNames {

        /**
         * Lists all commands and their use cases
         * Can add a String after to search command list
         */
        HELP,

        /**
         * Begins a basic Checkout operation
         * Can add flags after for more detailed operation
         */
        CHECKOUT,

        /**
         * "Prints" a receipt
         */
        RECEIPT,

        /**
         * Quits the application.
         */
        QUIT
    }

    /**
     * Initializes all Command Data for reference in the help command.
     * Should not be run more than once.
     */

    public static void Initialize() {
        CommandData.put(CommandNames.HELP, "HELP\n├Lists all commands and their use cases\n│└Syntax: Help\n└Looks up documentation for a specific command\n ├Syntax: Help [command]\n └Commands: [Any valid command name]");
        CommandData.put(CommandNames.CHECKOUT, "CHECKOUT\n└Begins a basic Checkout operation\n └Syntax: Checkout [Flags]\n  └Flags: [\"-d\": debug, \"-q\": quick test]\n   ├debug: \"Enables debug text and messages\"\n   └quick test: \"Instead of taking user input, runs a predefined routine for easy testing\"");
        CommandData.put(CommandNames.RECEIPT, "RECEIPT\n└\"Prints\" a receipt of latest checkout operation\n └Syntax: Receipt");
        CommandData.put(CommandNames.QUIT, "QUIT\n└Quits the application\n └Syntax: Quit");
    }
    
    /**
     * Lists all commands and their use cases.
     */
    public static void do_help() {
        // Loops through the Command Data map until the end
        // Prints provided information for each Command
        CommandData.entrySet().forEach((entry) -> {
            System.out.println(entry.getValue() + "\n");
        });
    }
    
    /**
     * Lists all commands and their use cases.
     * @param command Accepts a String to search command names for specifically.
     */
    public static void do_help(String command) {
        // Loops through the Command Data map until the end
        // If the name contains the searched for String, prints the Command info
        CommandData.entrySet().forEach((entry) -> {
            if (entry.getKey().name().contains(command)) {
                System.out.println(entry.getValue() + "\n");
            }
        });
    }
    
    /**
     * Begins a basic Checkout operation.
     * @param args Accepts an Array of Strings representing requested flags.
     */
    public static void do_checkout(String[] args) {
        Register_OS app = new Register_OS();
        System.out.println(app.pfac);
        app.run();
        
        
        // Code for checkout goes here OR reference to where it was created
    }
    
    /**
     * NOT IMPLEMENTED YET.
     * Prints out the user's receipt.
     */
    public static void do_receipt() {
        // This command will be implemented by someone else,
        //  then either connected to here or referenced here
    }

    /**
     * Quits the application with an exit code of 0.
     */
    public static void do_quit() {
        InputHandler.print("Goodbye!");
        System.exit(0);
    }
    
    /**
     * Quits the application.
     * @param exitCode Forces the exit to have this as its exit code.
     */
    public static void do_quit(int exitCode) {
        InputHandler.print("Goodbye!");
        System.exit(exitCode);
    }
}
>>>>>>> Stashed changes:src/Commands.java
