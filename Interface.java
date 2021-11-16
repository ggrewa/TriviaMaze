public class Interface {
  priavte static Scanner scanner = new Scanner(System.in);
  
  public static void printHomeScreen() {
    System.out.println("++ Welcome to TRIVIA MAZE ++" + "\n");
    //This part will show instructions,etc.
    System.out.println("InsTructions:");
    System.out.println();
    System.out.println("'L' shows locked doors");
    System.out.println("'X' shows the room you are in" + "\n");
    System.out.println("SELECT:" + "\n");
    System.out.println("1-New Game");
    System.out.println("2-Load Game");
    System.out.println("3-HELP MENU");
  }
  
  public static void printInGameMenu() {
    System.out.println("SELECT:" + "\n");
    System.out.println("1-New Game");
    System.out.println("2-Load Game");
    System.out.println("3-HELP MENU");
    System.out.println("4-Exit");
  }
  
  public static void printHelpMenu() {
    System.out.println("++ HELP MENU ++");
    System.out.println("");
    System.out.println("");
  }
  
  
}
