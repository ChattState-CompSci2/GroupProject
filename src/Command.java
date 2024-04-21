/**
 * A command that contains a method to call and help text.
 */
public class Command {
    
    private String helpText;
    private Runnable method;

    /**
     * Constructs a Command with a method and help text.
     * @param method the runnable method
     * @param helpText the help text
     */
    public Command(Runnable method, String helpText){
        this.method = method;
        this.helpText = helpText;
    }

    /**
     * @return the help text
     */
    public String getHelpText(){
        return this.helpText;
    }

    /**
     * Executes the method bound to this command
     */
    public void run(){
        method.run();
    }
}