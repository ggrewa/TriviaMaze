import java.io.Serializable;
import java.util.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import maze.Maze;


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
    } else if (homeSelection.equals("4")) {
      Interface.printExit();
    } else {
      System.out.println("Invalid entry!");
    }
  }  
  public static void saveGame(Maze maze) {
    try {
      FileInputStream file = new FileInputStream("GameSaved.ser");
      ObjectInputStream putIn = new ObjectInputStream(file);
      
      out.writeObject(maze);
      out.close();
      fileOut.close();
      System.out.println("Game saved! we'll keep your secrets safe!");   
      
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  public static void loadGame() {
    try {
      FileInputStream file = new FileInputStream("GameLoaded.ser");
      ObjectInputStream putIn = new ObjectInputStream(file);
            
      myMaze = (Maze)putIn.readObject();
      putIn.close();
      file.close();
      System.out.println("Game loaded! Taking you back to the magic!");                      
        
      } catch (IOException e) {
         System.out.print("Game could not be loaded. Need more pixie dust °o°!");
         playGame();
      } catch (ClassNotFoundException n) {
         System.out.print("Game not found. Need more pixie dust °o°!");
         n.printStackTrace();
         playGame();
     }  
  }
}

