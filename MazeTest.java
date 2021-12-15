package maze;

import database.DataBase;
import database.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for Maze class.
 *
 * @author Gurleen Grewal, Tarnveer Mangat, and Abdullah Enes
 * @version Autumn 2021
 *
 */
class MazeTest {
    private final InputStream IS = System.in;
    //private final PrintStream PS = System.out;

    private Maze myMaze;
    private Door myDoor;
    private Room myRoom;
    private Question myQuestion;
    private DataBase data;
    private Room[][] maze;
    //private Scanner myScan = new Scanner(System.in);

    transient private static final String ANSI_RESET = "\u001B[0m";

    transient private static final String ANSI_RED = "\033[0;31m";

    transient private static final String ANSI_BLUE = "\u001B[34m";

    //private Scanner myScan = new Scanner(System.in);
    /**
     * @throws java.lang.Exception
     */
    @BeforeEach
     void setUp() throws Exception {
        myMaze = new Maze();
        myDoor = new Door();
        myRoom = new Room();
        myQuestion = new Question(2);
        data = new DataBase();
        maze = myMaze.getMaze();
    }

    /**
     * Test for buildRooms method at Maze class
     */
    @Test
    void testBuildRooms() {
        myMaze.buildRooms();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++)  {
                assertNotNull(maze[i][j]);
            }
        }
    }


    /**
     * Test for setWalls method at Maze class
     */
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

    /**
     * Test for joinDoors method at Maze class
     */
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

    /**
     * Test for move method at Maze class for in case the answer is true
     */
    @Test
    void testMoveTrue() {
        myMaze.buildRooms();
        String input = "yes";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        myRoom.getDoor("north").setQuestionAnswered(true);
        myRoom.getDoor("north").setDoorlocked(true);
        myRoom.getDoor("north").setWall(true);
        myMaze.move("north");
        //assertEquals(false,  myRoom.getDoor("north").getQuestion().checkAnswer(data.getAnswer(2)));
    }

    /**
     * Test for move method at Maze class for in case the answer is false
     */
    @Test
    void testMoveFalse() {
        myMaze.buildRooms();
        String input = data.getAnswer(2);
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        myMaze.move("north");
        //assertEquals(false,  myRoom.getDoor("north").getQuestion().checkAnswer(data.getAnswer(2)));
    }


    /**
     * Test for moveUser method at Maze class
     */
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

    /**
     * Test for getHintNum method at Maze class
     */
    @Test
    void testGetHintNum() {
        myMaze.buildRooms();
        myMaze.setHintNum(2);
        assertEquals(2, myMaze.getHintNum());
    }

    /**
     * Test for setHintNum method at Maze class
     */
    @Test
    void testSetHintNum() {
        myMaze.buildRooms();
        myMaze.setHintNum(16);
        assertEquals(16, myMaze.getHintNum());
    }

    /**
     * Test for getHint method at Maze class in case the answer is "yes"
     */
    @Test
    void testGetHint() {
        myMaze.buildRooms();
        myMaze.setHintNum(3);
        String input = "yes";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        myMaze.getHint("north");
        assertEquals(2, myMaze.getHintNum());
        System.setIn(IS);
    }

    /**
     * Test for getHint method at Maze class in case the answer is "no"
     */
    @Test
    void testGetHintFalse() {
        myMaze.buildRooms();
        myMaze.setHintNum(3);
        String input = "n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        myMaze.getHint("north");
        assertEquals(3, myMaze.getHintNum());
        System.setIn(IS);
    }

    /**
     * Test for getLocation method at Maze class
     */
    @Test
    void testGetLocation() {
        myMaze.buildRooms();
        myMaze.setLocation(1,0);
        assertEquals(1,myMaze.getLocation()[0]);
        assertEquals(0,myMaze.getLocation()[1]);
    }

    /**
     * Test for setLocation method at Maze class
     */
    @Test
    void testSetLocation() {
        myMaze.buildRooms();
        myMaze.setLocation(0,2);
        assertEquals(0,myMaze.getLocation()[0]);
        assertEquals(2,myMaze.getLocation()[1]);
    }

    /**
     * Test for isGameOver method at Maze class
     */
    @Test
    void testIsGameOver() {
        myMaze.buildRooms();
        assertEquals(false, myMaze.getCurrentRoom().isRoomLocked());
    }

    /**
     * Test for isGameWon method at Maze class
     */
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
