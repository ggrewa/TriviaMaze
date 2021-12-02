package maze;

import java.io.Serializable;

public class Maze implements Serializable{
    
	private static final long serialVersionUID = -8540040586351459632L;
	
	private User myUser;

	private  Room[][] myMaze;
	
	private int myHintNum;
    
    public Maze() {
        myMaze = new Room[4][4];
        myUser = new User();
        myHintNum = 0;
        myUser.setX(0);
        myUser.setY(0);
        buildRooms();
    }
    
    public Room getCurrentRoom() {
    	return myMaze[myUser.getX()][myUser.getY()];
    }
    
    public void buildRooms() {
        for (int i = 0; i < myMaze.length; i++) {
            for(int j = 0; j < myMaze[0].length; j++) {
                myMaze[i][j] = new Room();
            }
        }
        setWalls();
        joinDoors();
    }
    
    public void setWalls() {
    	for(int i = 0; i < myMaze.length; i++) {
    		myMaze[0][i].getDoor("north").setWall(true);
    		myMaze[i][0].getDoor("west").setWall(true);
    		myMaze[myMaze.length-1][i].getDoor("south").setWall(true);
    		myMaze[i][myMaze.length-1].getDoor("east").setWall(true);
    	}
    }
    
    public void joinDoors() {
    	for(int i = 0; i < myMaze.length; i++) {
    		myMaze[1][i].setNorth(myMaze[0][i].getDoor("south")); 
    		myMaze[2][i].setNorth(myMaze[1][i].getDoor("south"));
    		myMaze[3][i].setNorth(myMaze[2][i].getDoor("south"));
    		
    		myMaze[i][0].setEast(myMaze[i][1].getDoor("west"));
    		myMaze[i][1].setEast(myMaze[i][2].getDoor("west"));
    		myMaze[i][2].setEast(myMaze[i][3].getDoor("west"));
    	}
    }
    
    public void move(String theDirection) {
    	Room currentRoom = getCurrentRoom();
    	Door currentDoor = currentRoom.getDoor(theDirection);
    	if(!currentDoor.getDoorLocked() && !currentDoor.getQuestionAnswered() &&
    			!currentDoor.getWall()) {
    		
    		System.out.println(currentDoor.getQuestion());
    		if(myHintNum > 0) {
    			boolean resultHint = currentDoor.getHint();
    			if(resultHint) {
    				myHintNum--;
    			}
    		}
    		boolean result = currentDoor.answerDoorQuestion();
    		
    		if(result) {
    			currentDoor.setDoorlocked(true);
    			currentDoor.setAnswerQuestion(true);
    			System.out.println("You got it!");
    			moveUser(theDirection);
    			//System.out.println("User location:" + myUser.getX() +"," + myUser.getY());
    			
    		} else {
    			currentDoor.setDoorlocked(false);
    			currentDoor.setAnswerQuestion(true);
    			System.out.println("Oops! The "+ theDirection +" door has been locked!");
    		}
    	} else {
    		if(currentDoor.getWall()) {
    			System.out.println("Oops! You hit a wall.");
    		}
    		if(!currentDoor.getDoorLocked() && currentDoor.getQuestionAnswered()) {
    			System.out.println("Oops! "+ theDirection + " door is locked!");
    		}
    		if(currentDoor.getDoorLocked() && currentDoor.getQuestionAnswered()) {
    			System.out.println("You got it!");
    			moveUser(theDirection);
    		}
    	}
    }  
    
    public void moveUser(String theDirection) {
    	if(theDirection.toLowerCase().equals("north")) {	//north
        	myUser.moveNorth();
        }
        if(theDirection.toLowerCase().equals("south")) {	//south
        	myUser.moveSouth();
        }
        if(theDirection.toLowerCase().equals("west")) {		//west
        	myUser.moveWest();
        }
        if(theDirection.toLowerCase().equals("east")) {		//east
        	myUser.moveEast();
        }
    }
    
    public void displayChoices() {
    	Room current = getCurrentRoom();
    	System.out.println("\n" + current.roomStatus());
    }

	public void setLocation(int theX, int theY) {
		myUser.setX(theX);
		myUser.setY(theY);
	}
	
	public int getHintNum() {
		return myHintNum;
	}
	
	public void setHintNum(int theHintNum) {
		myHintNum = theHintNum;
	}

	public boolean isGameOver() {
		boolean value = false;
		if(getCurrentRoom().isRoomLocked()) {
			value = true;
		}
		return value;
	}

	public boolean isGameWon() {
		boolean value = false;
		if(myUser.getX() == myMaze.length-1 && myUser.getY() == myMaze[0].length-1 &&
				myMaze[myMaze.length-1][myMaze[0].length-1].getDoor("east").getDoorLocked()) {
			value = true;
		}
		return value;
	}
}