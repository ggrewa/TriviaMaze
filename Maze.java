import java.io.Serializable;
import java.util.*;

public class Maze implements Serializable {
    private static final long serialVersionUID = 1L;
    private ArrayList[][] rooms;
    private int rows;
    //default number of rows
    private int rowsIndex = 4;
    private int cols;
    //default number of cols
    private int colsIndex = 4;
    private ArrayList[][] maze;

    public Maze() {
        this.rowsIndex = rowsIndex;
        this.colsIndex = colsIndex;
    }
    public Maze(int rows, int cols) {
        if(rows < 0 || cols < 0 || rows != cols) {
            throw new IllegalArgumentException("The maze is not in the specified dimension");
        }
        rowsIndex = 0;
        colsIndex = 0;
        
    }

    public ArrayList rooms (int row, int col) {

    }
    public ArrayList maze (int row, int col) {

    }

    public void movement(char direction) {


    }

    public void checkLocation(int row, int col) {
        if(row < 0 || col < 0 || row >= rooms.length || col >= rooms.length) {
            throw new IllegalArgumentException("You are out of bounds");
        }
        rowsIndex = row;
        colsIndex = col;
    }

    public static void status(boolean result) {
        if (!result) {
            System.out.println("You got stucked!");
        } else {
            System.out.println("You completed the maze!");
        }
    }
    @override
    public static String toString () {
        StringBuilder sb = new StringBuilder;
        for(int i = 0; i < maze.size(); i++) {
            sb.append(maze.charAt(i)) + "\n");
        }
        return sb.toString();
    }
}
