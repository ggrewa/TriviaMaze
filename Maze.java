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
    private Door currDoor;

    public Maze() {
        if(rows < 0 || cols < 0 || rows != cols) {
            throw new IllegalArgumentException("The maze is not in the specified dimension");
        }
        rows = 4;
        cols = 4;
        maze = new Room[rows][cols];
        rowsIndex = 0;
        colsIndex = 0;
    }

    public void buildRooms() {
        for (int i = 0; i < rows; i++) {
            maze[i][0].Room.getEast().setDoor(Door.getWall());
        }
        for(int j = 0; j < cols; j++) {
            maze[0][j].Room.getNorth().setDoor(Door.getWall());
        }
        for (int i = 0; i < rows; i++) {
            maze[i][cols].Room.getWest().setDoor(Door.getWall());
        }
        for(int j = 0; j < cols; j++) {
            maze[rows][j].Room.getSouth().setDoor(Door.getWall());
        }
    }
    public void buildMaze (int rows, int cols) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                maze = new Room();
            }
        }
    }

    public Room[][] getCurrentRoom() {
        return room;
    }
    
    public Room[][] getMaze() {
        return maze;
    }

    public void checkLocation(int row, int col) {
        if(row < 0 || col < 0 || row >= rooms.length || col >= rooms.length) {
            throw new IllegalArgumentException("You are out of bounds");
        }
        rowsIndex = row;
        colsIndex = col;
    }
    
    public void movement() {
        if (Game.North() && Door.getWall() && canMoveNorth(currentDir)) { 
            rowsIndex--;
        } else if (Game.South() && Door.getWall() && canMoveSouth(currentDir)) {
            rowsIndex++;
        } else if (Game.West() && Door.getWall() && canMoveWest(currentDir)) {
            colsIndex--;
        } else if (Game.East() && Door.getWall() && canMoveEast(currentDir)) {
            colsIndex++;
        }
    }

    public void canMoveNorth(String currentDir) {
        if (currentDir.toLowerCase().equals("N")) {
            currDoor = maze[rowsIndex][colsIndex].getNorth();
        }
    }
    public void canMoveSouth(String currentDir) {
        if (currentDir.toLowerCase().equals("S")) {
            currDoor = maze[rowsIndex][colsIndex].getSouth();
        }
    }
    public void canMoveWest(String currentDir) {
        if (currentDir.toLowerCase().equals("W")) {
            currDoor = maze[rowsIndex][colsIndex].getWest();
        }
    }
    public void canMoveEast(String currentDir) {
        if (currentDir.toLowerCase().equals("E")) {
            currDoor = maze[rowsIndex][colsIndex].getEast();
        }
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
