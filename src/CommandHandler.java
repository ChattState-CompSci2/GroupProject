import java.util.HashMap;
import java.util.Map;

/**
 * Contains the Map of commands and code to add, list and get them.
 */
public class CommandHandler {
    
    private Map<String, Command> commands;

    /**
     * Constructs a new CommandHandler with an empty command Map.
     */
    public CommandHandler(){
        commands = new HashMap<>();
    }

    /**
     * Adds a new command to the command Map
     * @param name the name of the command
     * @param c the command to be added. Contains method and help text
     */
    public void addCommand(String name, Command c){
        commands.put(name.toUpperCase(), c);
    }

    /**
     * Gets a command by its name.
     *
     * @param name the name of the command
     * @return the command or null if not found
     */
    public Command getCommand(String name){
        return commands.get(name.toUpperCase());
    }
 
    /**
     * Prints a list of all commands and their help texts.
     */
    public void listCommands(){
        System.out.println("Commands:");
        for (Map.Entry<String, Command> entry : commands.entrySet()) {
            System.out.printf("\t%-8s: %s\n", entry.getKey(), entry.getValue().getHelpText());
        }
    }
}