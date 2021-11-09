package model;

public class HelpMenu {
    private String instructions;
    private String hints;
    
    public HelpMenu() {
        this.instructions = instructions;
        this.hints = hints;
    }
    
    public String getInstructions() {
        return instructions;
    }
    public String getHints() {
        return hints;
    }
    
    public String toString() {
      return "Instructions: " + intructions + /n + "Hints = " + hints;   
    }
}
