package maze;

import database.DataBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DoorTest extends Door {

    @Test
    public void testGetQuestion() {
        DataBase data = new DataBase();
        assertEquals("What are Hade's minions called in Hercules? Enter answer separated by commas in aplhabetical order. mcq?", data.getQuestion(4));
        assertEquals("What were Mickey Mouse's first words ever spoken?", data.getQuestion(16));
        assertEquals("Name Wendy's dog.", data.getQuestion(32));
        assertEquals("Which disney film has the song 'Let it Go'?", data.getQuestion(1));
        assertEquals("Cinderella's two step sisters are ______ and _____. Enter names separated by a comma.", data.getQuestion(3));
    }

    @Test
    void testGetDoorLocked() {
        Door door = new Door();
        door.setDoorlocked(false);
        assertEquals(false, door.getDoorLocked());
    }

    @Test
    void testGetDoorNotLocked() {
        Door door = new Door();
        door.setDoorlocked(true);
        assertEquals(true, door.getDoorLocked());
    }

    @Test
    void testSetDoorlocked() {
        Door door = new Door();
        door.setDoorlocked(true);
        assertEquals(true, door.getDoorLocked());
    }

    @Test
    void testGetQuestionAnswered() {
        Door door = new Door();
        door.setAnswerQuestion(true);
        assertEquals(true, door.getQuestionAnswered());
    }

    @Test
    void testGetQuestionNotAnswered() {
        Door door = new Door();
        door.setAnswerQuestion(false);
        assertEquals(false, door.getQuestionAnswered());
    }

    @Test
    void testSetAnswerQuestion() {
        Door door = new Door();
        door.setAnswerQuestion(true);
        assertEquals(true, door.getQuestionAnswered());
    }

    @Test
    void testGetWall() {
        Door door = new Door();
        door.setWall(true);
        assertEquals(true, door.getWall());
    }

    @Test
    void testSetWall() {
        Door door = new Door();
        door.setWall(false);
        assertEquals(false, door.getWall());
    }

    @Test
    void testAnswerDoorQuestion() {
        DataBase data = new DataBase();
        assertEquals("frozen", data.getAnswer(1));
        assertEquals("hot dog!", data.getAnswer(16));
        assertEquals("nana", data.getAnswer(32));
        assertEquals("pain, panic", data.getAnswer(4));
        assertEquals("true", data.getAnswer(23));
    }
}
