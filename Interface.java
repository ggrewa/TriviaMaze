import java.util.*;

public class Interface {
  priavte static Scanner scanner = new Scanner(System.in);
  
  public static void printHomeScreen() {
    System.out.println("++ Welcome to TRIVIA MAZE ++" + "\n");
    //This part will show instructions,etc.
    System.out.println("SELECT:" + "\n");
    System.out.println("1-New Game");
    System.out.println("2-Load Game");
    System.out.println("3-HELP MENU");
    System.out.println();
  }
  //make sure user makes a valid entry to select an option from the homescreen menu
  public static String getUserSelectionAtHome() {
    String homeSelection = scanner.next();
    String[] homeOptions = new String[]{"1", "2", "3"};
    do {
         System.out.println("Entry is not Valid!");
         homeSelection = scanner.next();
    } while(!homeOptions.contains(homeSelection));
    return homeSelection;
  }
  
  public static void printInGameMenu() {
    System.out.println("SELECT:" + "\n");
    System.out.println("1-New Game");
    System.out.println("2-Load Game");
    System.out.println("3-HELP MENU");
    System.out.println("4-Exit");
    System.out.println();
  }
  
  //make sure user makes a valid entry to select an option from the in game menu
  public static String getUserSelectionInGame() {
    String menuSelection = scanner.next();
    String[] menuOptions = new String[]{"1", "2", "3", "4"};
    do {
         System.out.println("Entry is not Valid!");
         menuSelection = scanner.next();
    } while(!menuOptions.contains(menuSelection));
    return menuSelection;
  }
  
  public static void printHelpMenu() {
    System.out.println("++ HELP MENU ++");
    System.out.println();
    System.out.println("InsTructions:");
    System.out.println("'L' shows locked doors");
    System.out.println("'X' shows the room you are in" + "\n");
    System.out.println();
  }
  
  public static void printExit() {
    System.out.println("You Exit the game!);
  }
}
