import java.io.Serializable;
import java.util.*;

public class Maze implements Serializable {
  private static final long serialVersionUID = 1L;
  private ArrayList[][] rooms;
  private int rows;
  private int cols;
  private ArrayList[][] maze;
  
  public Maze() {
    this.rows = rows;
    this.cols = cols;
  }
  public static boolean homeScreen() {
    Interface.printHomeScreen();
  }
  public ArrayList rooms (int row, int col) {
    //
  }
  public ArrayList maze (int row, int col) {
  }
  public void movement(char direction) {
  } 
  public static boolean helpMenu() {
    Interface.printHelpMenu();
  }
  @override
  public static String toString () {
    StringBuilder sb = new StringBuilder;
    return sb.toString();
  }
}
