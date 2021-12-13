package maze;

import database.DataBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DoorTest {

    private Door door;
    private DataBase data;

    @BeforeEach
    void setUp() {
        door = new Door();
        data = new DataBase();
    }

    @Test
    public void testGetQuestion() {
        assertEquals("What are Hade's minions called in Hercules? Enter answer separated by commas in aplhabetical order. mcq?", data.getQuestion(4));
        assertEquals("What were Mickey Mouse's first words ever spoken?", data.getQuestion(16));
        assertEquals("Name Wendy's dog.", data.getQuestion(32));
        assertEquals("Which disney film has the song 'Let it Go'?", data.getQuestion(1));
        assertEquals("Cinderella's two step sisters are ______ and _____. Enter names separated by a comma.", data.getQuestion(3));
    }

    @Test
    void testGetDoorLocked() {
        door.setDoorlocked(false);
        assertEquals(false, door.getDoorLocked());
    }

    @Test
    void testGetDoorNotLocked() {
        door.setDoorlocked(true);
        assertEquals(true, door.getDoorLocked());
    }

    @Test
    void testSetDoorlocked() {
        door.setDoorlocked(true);
        assertEquals(true, door.getDoorLocked());
    }

    @Test
    void testGetQuestionAnswered() {
        door.setQuestionAnswered(true);
        assertEquals(true, door.getQuestionAnswered());
    }

    @Test
    void testGetQuestionNotAnswered() {
        door.setQuestionAnswered(false);
        assertEquals(false, door.getQuestionAnswered());
    }

    @Test
    void testSetAnswerQuestion() {
        door.setQuestionAnswered(true);
        assertEquals(true, door.getQuestionAnswered());
    }

    @Test
    void testGetWall() {
        door.setWall(true);
        assertEquals(true, door.getWall());
    }

    @Test
    void testSetWall() {
        door.setWall(false);
        assertEquals(false, door.getWall());
    }
}
