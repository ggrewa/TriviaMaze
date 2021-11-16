import java.io.Serializable;
import java.util.*;

public class GameOperations implements Serializable {
  private static final long serialVersionUID = 1L;
  private static numMoves;
  
  public static void newGame(Maze maze) {
    
  }
  public static void PlayGame(Maze maze) {
    Interface.printHomeScreen();
    String homeSelection = Interface.getUserSelectionAtHome();
    
    if (homeSelection.equals("1")) {
      Maze maze = new Maze();
      newGame();
    } else if (homeSelection.equals("2")) {
      loadGame();
    } else if (homeSelection.equals("3")) {
      Interface.printHelpMenu();
    } else {
      System.out.println("Invalid entry!");
    }
  }  
  public static void exitGame(Maze maze) {
    
  }
  public static void saveGame(Maze maze) {
    
  }
  
  public static void loadGame(Maze maze) {
    
  }
}

