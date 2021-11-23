import java.io.Serializable;
import java.util.*;

public class Maze implements Serializable {
    private static final long serialVersionUID = 1L;
    private Room[][] rooms;
    private int rows;
    //default number of rows
    private int rowsIndex;
    private int cols;
    //default number of cols
    private int colsIndex;
    private Room[][] maze;
    
    public Maze() {
        if(rows < 0 || cols < 0 || rows != cols) {
            throw new IllegalArgumentException("The maze is not in the specified dimension");
        }
        maze = new Room[4][4];
        rowsIndex = 0;
        colsIndex = 0;
        buildRooms();
        buildMaze();
    }

    public void buildRooms (int rows, int cols) {
        Door North = new Door();
        Door South = new Door();
        Door East = new Door();
        Door West = new Door();
        for (int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                boolean north = false;
                boolean south = false;
                boolean east = false;
                boolean west = false;
                
                if(cols > 0) {
                    North = maze[rows][cols - 1].getDoor(1);
                }
            }
        }
        return rooms;

    }
    public ArrayList maze (int rows, int cols) {
        
    }
    
    public int getRows() {
        return rows;
    }
    
    public int getCols() {
        return cols;
    }
    
    public void setRowsAndCols(int rows, int cols) {
        myRows = rows;
        myCols = cols;
    }
    
    public Room getCurrentRoom() {
        return maze[rows][cols];
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
