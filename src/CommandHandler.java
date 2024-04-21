import java.util.HashMap;
import java.util.Map;

public class CommandHandler {
    
    private Map<String, Command> commands;


    public CommandHandler(){
        commands = new HashMap<>();
    };

    public void addCommand(String name, Command c){
        commands.put(name.toUpperCase(), c);
    }

    public Command getCommand(String name){
        return commands.get(name.toUpperCase());
    }
 
    public void listCommands(){
        for (Map.Entry<String, Command> entry : commands.entrySet()) {
            System.out.printf("%-8s: %s\n", entry.getKey(), entry.getValue().getHelpText());
        }
    }
}
