public class Command {
    
    private String helpText;
    private Runnable method;

    Command(Runnable method, String helpText){
        this.method = method;
        this.helpText = helpText;
    }

    // No Setters. Immutable

    public String getHelpText(){
        return this.helpText;
    }

    public void run(){
        method.run();
    }

}
