package model;

public class HelpMenu {
    private String instructions;
    private String hints;
    
    public HelpMenu() {
        DataBase db = new DataBase();
        instructions = db.getInstructions();
    }
    
    public String getInstructions() {
        return instructions;
    }

    public String toString() {
      return "++ HELP MENU ++" + /n + "Instructions: " + intructions + /n + "Hints = " + hints;   
    }
}
