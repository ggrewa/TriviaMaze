package programs;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class MazeBuilder implements Serializable {
        
 
    private static final long serialVersionUID = 1L;

        private  Room[][] myMaze;
      
        private Room myRoom;
        
         
        private int myPlayerRow;
        
        private int myPlayerColumn;
        
        public MazeBuilder() {
            myMaze = new Room[4][4];
            myPlayerRow = 0;
            myPlayerColumn = 0;
  
        }
        
        public void maze() {
            final StringBuilder builder = new StringBuilder();
            for (int i = 0; i < myMaze.length; i++) {
                for(int j = 0; j < myMaze[0].length; j++) {
                    myMaze = new Room();
                }
    
            }
        
        }
        public void outOfBounds() {
            String message = "The player is out of bounds.";
            if (myPlayerRow < 0) {
                throw new IllegalArgumentException(message);
            }
            if (myPlayerColumn < 0) {
                throw new IllegalArgumentException(message);
            }
            if (myMaze.length < 4) {
                throw new IllegalArgumentException(message);
            }        
        }
        
        public Room[][] getMaze() {
            return myMaze;
        }

        
        //public void startGame() {
            //while
        
        //}
        public void borderRooms() {
            for (int j =1; j <= 4; j++) {
                myMaze[0][j].getMyNorth().setDoor(Door.myWall);
            }
            for (int j = 1; j <= 4; j++) {
                myMaze[4][j].getMySouth().setDoor(Door.myWall);
            }
            for (int i = 1; i <= 4; i++) {
                myMaze[i][0].getMyEast().setDoor(Door.myWall);
            }
            for (int i = 1; i <= 4; i++) {
                myMaze[i][4].getmyWest().setDoor(Door.myWall);
            }
         
        }
        
        public void playerCanMove(String currentDir) {
            Door currentDoor = null;
            if(currentDir.toLowerCase().equals("North")) {
                currentDoor = myMaze[myPlayerRow][myPlayerColumn].getNorth();
            }
            else if (currentDir.toLowerCase().equals("East")) {
                currentDoor = myMaze[myPlayerRow][myPlayerColumn].getEast();
            }
            else if (currentDir.toLowerCase().equals("West")) {
                currentDoor = myMaze[myPlayerRow][myPlayerColumn].getWest();
            }
            else if (currentDir.toLowerCase().equals("South")) {
                currentDoor = myMaze[myPlayerRow][myPlayerColumn].getSouth();
            }
        }
//        avaliable doors for user in a room
//        game over and if game is won
//      } avalable doors and position

        public int xCor() {
            return myPlayerRow;
        }
        public int yCor() {
            return myPlayerColumn;
        }
        public void move() {
            if (playerMoveNorth() && Door.getWall() && playerCanMove(currentDir)) { //for border walls
                myPlayerRow--;
            } else if (playerMoveEast() && Door.getWall() && playerCanMove(currentDir)) {
                myPlayerColumn++;
            } else if (playerMoveWest() && Door.getWall() && playerCanMove(currentDir)) {
                myPlayerColumn--;
            } else if (playerMoveSouth() && Door.getWall() && playerCanMove(currentDir)) {
                myPlayerRow++;
            }
        }
        
        public boolean playerMoveNorth() {
            if (myPlayerRow - 1 > -1 && Question.checkAnswer()) {
                return true;
            } else {
                return false;
            }
          
        }
        public boolean playerMoveEast() {
            if (myPlayerColumn + 1 <= 5 && Question.checkAnswer()) {
                return true;
            } else {
                return false;
            }
          
        }
        public boolean playerMoveWest() {
            if (myPlayerColumn - 1 > -1 && Question.checkAnswer()) {
                return true;
            } else {
                return false;
            }
          
          }  
          
        public boolean playerMoveSouth() {
            if (myPlayerRow + 1 <= 5 && Question.checkAnswer()) {
                return true;
            } else {
                return false;
            }
          
          }      
}
