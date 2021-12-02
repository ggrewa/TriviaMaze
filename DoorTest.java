package maze;

import database.DataBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DoorTest {

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
    void testGetHint() {
        DataBase data = new DataBase();
        assertEquals("Elsa and Anna are a part of this movie.", data.getHint(1));
        assertEquals("Another word for corn dogs.", data.getHint(16));
        assertEquals("His name starts with the letter 'n'.", data.getHint(32));
        assertEquals("How do you feel when you get hurt or sick?", data.getHint(4));
        assertEquals("I love the food at Joey's!", data.getHint(6));
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
