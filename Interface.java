import java.util.*;

public class Interface {
  priavte static Scanner scanner = new Scanner(System.in);
  
  public static void printHomeMenu() {
     System.out.println("1-New Game");
     System.out.println("2-Load Game");
     System.out.println("3-Help Menu");
     System.out.println("4-Quit \n");
  }
  
  //make sure user makes a valid entry to select an option from the menu
  public static String getHoneSelection() {
    String homeSelection = scanner.next();
    String[] homeOptions = new String[]{"1", "2", "3", "4"};
    do {
         System.out.println("Entry is not Valid!");
         homeSelection = scanner.next();
    } while(!homeOptions.contains(homeSelection));
    return menuSelection;
  }
  
  public static void printHelpMenu() {
    printHelpMenuIntro();
    	
    System.out.println("About:");
    System.out.println("Disney Trivia Maze is a trivia based game that consists of disney "
    			+ "themed questions. At the beginning of the game, the player is put at the "
    			+ "start of the maze. The aim of the game is to make way to the end of the "
    			+ "maze by walking through various door and rooms and answering the trivia"
    			+ "questions. If the user is stuck in a room and is unable to answer any of "
    			+ "the questions in the room correctly, the game is over.\n");
    	
    //Add instructions...
    System.out.println("Instructions:");
    System.out.println("'L' shows locked doors");
    System.out.println("'X' shows the room you are in" + "\n");
    System.out.println();
  }
  
  public static void printInGameMenu() {
    System.out.println("1-New Game");
    System.out.println("2-Load Game");
    System.out.println("3-HELP MENU");
    System.out.println("5-Save Game);
    System.out.println("4-Exit \n");
  }
  
  //make sure user makes a valid entry to select an option from the menu
  public static String getGameMenuSelection() {
    String gameMenuSelection = scanner.next();
    String[] gameMenuOptions = new String[]{"1", "2", "3", "4", "5"};
    do {
         System.out.println("Entry is not Valid!");
         gameMenuSelection = scanner.next();
    } while(!gameMenuOptions.contains(gameMenuSelection));
    return gameMenuSelection;
  }
                    
  
  public char getDirection (Maze maze) {
  }
  
  public static void printExit() {
    System.out.println("You Exit the game!");
    printGameOutro();
  }
                       
  public static void printGameIntro() {
    System.out.println("                ,n888888n,");
    System.out.println("               .8888888888b");
    System.out.println("               888888888888nd8P~''8g,");
    System.out.println("               88888888888888   _  `'~\\.  .n.");
    System.out.println("               `Y888888888888. / _  |~\\ (8\"8b");
    System.out.println("              ,nnn.. 8888888b.  |  \\ \\m\\|8888P");
    System.out.println("            ,d8888888888888888b. \\8b|.\\P~ ~P8~");
    System.out.println("            888888888888888P~~_~  `8B_|      |");
    System.out.println("            ~888888888~'8'   d8.    ~      _/");
    System.out.println("             ~Y8888P'   ~\\ | |~|~b,__ __--~");
    System.out.println("         --~~\\   ,d8888888b.\\`\\_/ __/~");
    System.out.println("              \\_ d88888888888b\\_-~8888888bn.");
    System.out.println("                \\8888P   \"Y888888888888\"888888bn.");
    System.out.println("            /~'\\_\"__)      \"d88888888P,-~~-~888");
    System.out.println("           /  / )   ~\\     ,888888/~' /  / / 8'");
    System.out.println("        .-(  / / / |) )-----------(/ ~  / /  |---.");
    System.out.println(" ______ | (   '    /_/ Disney Trivia(__/     /   |_______");
    System.out.println(" \\      |   (_(_ ( /~      Maze      \\___/_/'    |      /");
    System.out.println("  \\     |  Welcome, Let's test your knowledge!   |     /");
    System.out.println("  /     (________________________________________)     \\");
    System.out.println(" /__________)     __--|~mb  ,g8888b.         (__________\\");
    System.out.println("               _/    8888b(.8P\"~'~---__");
    System.out.println("              /       ~~~| / ,/~~~~--, `\\");
    System.out.println("             (       ~\\,_) (/         ~-_`\\\\");
    System.out.println("              \\  -__---~._ \\             ~\\\\");
    System.out.println("              (           )\\\\              ))\\");
    System.out.println("              `\\          )  \"-_           `|\\");
    System.out.println("                \\__    __/      ~-__   __--~\\\\");
    System.out.println("                   ~~\"~             ~~~\n");
   }
    
  public static void printHelpMenuIntro() {
    System.out.println("                ,n888888n,");
    System.out.println("               .8888888888b");
    System.out.println("               888888888888nd8P~''8g,");
    System.out.println("               88888888888888   _  `'~\\.  .n.");
    System.out.println("               `Y888888888888. / _  |~\\ (8\"8b");
    System.out.println("              ,nnn.. 8888888b.  |  \\ \\m\\|8888P");
    System.out.println("            ,d8888888888888888b. \\8b|.\\P~ ~P8~");
    System.out.println("            888888888888888P~~_~  `8B_|      |");
    System.out.println("            ~888888888~'8'   d8.    ~      _/");
    System.out.println("             ~Y8888P'   ~\\ | |~|~b,__ __--~");
    System.out.println("         --~~\\   ,d8888888b.\\`\\_/ __/~");
    System.out.println("              \\_ d88888888888b\\_-~8888888bn.");
    System.out.println("                \\8888P   \"Y888888888888\"888888bn.");
    System.out.println("            /~'\\_\"__)      \"d88888888P,-~~-~888");
    System.out.println("           /  / )   ~\\     ,888888/~' /  / / 8'");
    System.out.println("        .-(  / / / |) )-----------(/ ~  / /  |---.");
    System.out.println(" ______ | (   '    /_/ Disney Trivia(__/     /   |_______");
    System.out.println(" \\      |   (_(_ ( /~      Maze      \\___/_/'    |      /");
    System.out.println("  \\     |  Welcome, Let's test your knowledge!   |     /");
    System.out.println("  /     (________________________________________)     \\");
    System.out.println(" /__________)     __--|~mb  ,g8888b.         (__________\\");
    System.out.println("               _/    8888b(.8P\"~'~---__");
    System.out.println("              /       ~~~| / ,/~~~~--, `\\");
    System.out.println("             (       ~\\,_) (/         ~-_`\\\\");
    System.out.println("              \\  -__---~._ \\             ~\\\\");
    System.out.println("              (           )\\\\              ))\\");
    System.out.println("              `\\          )  \"-_           `|\\");
    System.out.println("                \\__    __/      ~-__   __--~\\\\");
    System.out.println("                   ~~\"~             ~~~\n");
   }
    
   public static void printGameOutro() {
    System.out.println("                ,n888888n,");
    System.out.println("               .8888888888b");
    System.out.println("               888888888888nd8P~''8g,");
    System.out.println("               88888888888888   _  `'~\\.  .n.");
    System.out.println("               `Y888888888888. / _  |~\\ (8\"8b");
    System.out.println("              ,nnn.. 8888888b.  |  \\ \\m\\|8888P");
    System.out.println("            ,d8888888888888888b. \\8b|.\\P~ ~P8~");
    System.out.println("            888888888888888P~~_~  `8B_|      |");
    System.out.println("            ~888888888~'8'   d8.    ~      _/");
    System.out.println("             ~Y8888P'   ~\\ | |~|~b,__ __--~");
    System.out.println("         --~~\\   ,d8888888b.\\`\\_/ __/~");
    System.out.println("              \\_ d88888888888b\\_-~8888888bn.");
    System.out.println("                \\8888P   \"Y888888888888\"888888bn.");
    System.out.println("            /~'\\_\"__)      \"d88888888P,-~~-~888");
    System.out.println("           /  / )   ~\\     ,888888/~' /  / / 8'");
    System.out.println("        .-(  / / / |) )-----------(/ ~  / /  |---.");
    System.out.println(" ______ | (   '    /_/ Disney Trivia(__/     /   |_______");
    System.out.println(" \\      |   (_(_ ( /~      Maze      \\___/_/'    |      /");
    System.out.println("  \\     |  Welcome, Let's test your knowledge!   |     /");
    System.out.println("  /     (________________________________________)     \\");
    System.out.println(" /__________)     __--|~mb  ,g8888b.         (__________\\");
    System.out.println("               _/    8888b(.8P\"~'~---__");
    System.out.println("              /       ~~~| / ,/~~~~--, `\\");
    System.out.println("             (       ~\\,_) (/         ~-_`\\\\");
    System.out.println("              \\  -__---~._ \\             ~\\\\");
    System.out.println("              (           )\\\\              ))\\");
    System.out.println("              `\\          )  \"-_           `|\\");
    System.out.println("                \\__    __/      ~-__   __--~\\\\");
    System.out.println("                   ~~\"~             ~~~\n");
  }                     
}
