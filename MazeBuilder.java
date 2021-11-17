package programs;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MazeBuilder {
        
        private  Room[][] myMaze;
      
        
        
         
        private int myPlayerRow;
        
        private int myPlayerColumn;
        
        public MazeBuilder() {
            myMaze = new Room[4][4];
  
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
        /**
         * https://www.tutorialspoint.com/java/java_serialization.htm
         */
        public void saveGame() {
            try {
                     FileOutputStream file = new FileOutputStream("GameSaved.ser");
                     ObjectOutputStream putOut = new ObjectOutputStream(file);
                     putOut.writeObject(myMaze);
                     putOut.close();
                     file.close();
                     System.out.println("The game has been saved. ");
            } catch (IOException i) {
                System.out.println("The game hasn't been saved.");
            
            }
        }
        
        public void loadGame() {
            try {
                Room[][] maze = null;
                FileInputStream file = new FileInputStream("GameSaved.ser");
                ObjectInputStream putIn = new ObjectInputStream(file);
                maze = (Room[][]) putIn.readObject();
                putIn.close();
                file.close();
                System.out.println("Game loaded!");
                MazeBuilder game = new MazeBuilder(maze);
                //game.startGame(); //method                       
            
            } catch (IOException i) {
                System.out.print("Game could not be downloaded.");
                return;
            } catch (ClassNotFoundException n) {
                System.out.print("Game not found.");
                n.printStackTrace();
                return;
            
            }
        
        }
        
        //public void startGame() {
            //while
        
        //}
        public void borderRooms() {
            for (int j =1; j <= 4; j++) {
                myMaze[1][j].getMyNorth().setDoor(Door.myWall);
            }
            for (int j = 1; j <= 4; j++) {
                myMaze[4][j].getMySouth().setDoor(Door.myWall);
            }
            for (int i = 1; i <= 4; i++) {
                myMaze[i][1].getMyEast().setDoor(Door.myWall);
            }
            for (int i = 1; i <= 4; i++) {
                myMaze[i][4].getmyWest().setDoor(Door.myWall);
            }
         
        }
        

        
        

}
