package maze;

import database.DataBase;
import database.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MazeTest {

    private Maze myMaze;
    private Door myDoor;
    private Room myRoom;
    private Question myQuestion;
    private DataBase data;
    private Room[][] maze;


    @BeforeEach
    void setUp() {
        myMaze = new Maze();
        myDoor = new Door();
        myRoom = new Room();
        myQuestion = new Question();
        data = new DataBase();
        maze = myMaze.getMaze();
    }

    @Test
    void testBuildRooms() {
        myMaze.buildRooms();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++)  {
                assertNotNull(maze[i][j]);
            }
        }
    }

    @Test
    void testSetWalls() {
        myMaze.buildRooms();
        for(int i = 0; i < maze.length; i++) {
            maze[0][i].getDoor("north").setWall(true);
            assertEquals(true, maze[0][i].getDoor("north").getWall());
            maze[i][0].getDoor("west").setWall(true);
            assertEquals(true, maze[i][0].getDoor("west").getWall());
            maze[maze.length-1][i].getDoor("south").setWall(true);
            assertEquals(true, maze[maze.length-1][i].getDoor("south").getWall());
            maze[i][maze.length-1].getDoor("east").setWall(true);
            assertEquals(true, maze[i][maze.length-1].getDoor("east").getWall());
        }
        maze[3][maze.length-1].getDoor("east").setWall(false);
        assertEquals(false, maze[3][maze.length-1].getDoor("east").getWall());
    }
    @Test
    void testJoinDoors() {
        myMaze.buildRooms();
        for(int i = 0; i < maze.length; i++) {
            maze[1][i].setNorth(maze[0][i].getDoor("south"));
            assertEquals(false, maze[1][i].getDoor("south").getWall());

            maze[i][0].setEast(maze[i][1].getDoor("west"));
            assertEquals(false, maze[i][1].getDoor("west").getWall());
        }
    }

    @Test
    void testMoveUser() {
        myMaze.buildRooms();
        myMaze.moveUser("north");
        assertEquals(0, myMaze.getLocation()[0]);
        assertEquals(-1, myMaze.getLocation()[1]);

        myMaze.moveUser("south");
        assertEquals(0, myMaze.getLocation()[0]);
        assertEquals(0, myMaze.getLocation()[1]);

        myMaze.moveUser("east");
        assertEquals(1, myMaze.getLocation()[0]);
        assertEquals(0, myMaze.getLocation()[1]);

        myMaze.moveUser("west");
        assertEquals(0, myMaze.getLocation()[0]);
        assertEquals(0, myMaze.getLocation()[1]);
    }

    @Test
    void testGetHintNum() {
        myMaze.buildRooms();
        myMaze.setHintNum(2);
        assertEquals(2, myMaze.getHintNum());
    }

    @Test
    void testSetHintNum() {
        myMaze.buildRooms();
        myMaze.setHintNum(16);
        assertEquals(16, myMaze.getHintNum());
    }

    @Test
    void testGetLocation() {
        myMaze.buildRooms();
        myMaze.setLocation(1,0);
        assertEquals(1,myMaze.getLocation()[0]);
        assertEquals(0,myMaze.getLocation()[1]);
    }

    @Test
    void testSetLocation() {
        myMaze.buildRooms();
        myMaze.setLocation(0,2);
        assertEquals(0,myMaze.getLocation()[0]);
        assertEquals(2,myMaze.getLocation()[1]);
    }

    @Test
    void testIsGameOver() {
        myMaze.buildRooms();
        assertEquals(false, myMaze.getCurrentRoom().isRoomLocked());
    }

    @Test
    void testIsGameWon() {
        myMaze.buildRooms();
        User myUser = new User();
        myUser.setX(maze.length-1);
        Boolean row = myUser.getX() == maze.length-1;
        myUser.setY(maze[0].length-1);
        Boolean col = myUser.getY() == maze[0].length-1;
        maze[maze.length-1][maze[0].length-1].getDoor("east").setDoorlocked(true);
        Boolean door =  maze[maze.length-1][maze[0].length-1].getDoor("east").getDoorLocked();
        assertTrue(row && col && door);
    }
}
