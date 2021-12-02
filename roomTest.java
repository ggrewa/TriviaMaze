package test;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

import maze.Door;
import maze.Room;

public class roomTest extends Room {
	Room room = new Room();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Test
	public void testSetNorth() {
		Room room = new Room();
		Door myNorth = new Door();
		room.setNorth(myNorth);
		myNorth.setDoorlocked(true);
	    assertEquals(true, myNorth.getDoorLocked());
	   
	
	}
	@Test
	public void testSetSouth() {
		Room room = new Room();
		Door mySouth = new Door();
		room.setSouth(mySouth);
		mySouth.setDoorlocked(true);
	    assertEquals(true, mySouth.getDoorLocked());
	}
	@Test
	public void testSetEast() {
		Room room = new Room();
		Door myEast = new Door();
		room.setEast(myEast);
		myEast.setDoorlocked(true);
	    assertEquals(true, myEast.getDoorLocked());
	}
	@Test
	public void testSetWest() {
		Room room = new Room();
		Door myWest = new Door();
		room.setWest(myWest);
		myWest.setDoorlocked(true);
	    assertEquals(true, myWest.getDoorLocked());
	}
	@Test
	public void testNorthGetDoor() {
		Room room = new Room();
		Door myNorth = new Door();
		room.setNorth(myNorth);
		assertEquals(true, room.getNorth());

	}
	@Test
	public void testSouthGetDoor() {
		Room room = new Room();
		Door mySouth = new Door();
		room.setSouth(mySouth);
		assertEquals(false, room.getSouth());

	}
	@Test
	public void testEastGetDoor() {
		Room room = new Room();
		Door myEast = new Door();
		room.setEast(myEast);
		assertEquals(true, room.getEast());
	}
	@Test
	public void testWestGetDoor() {
		Room room = new Room();
		Door myWest = new Door();
		room.setWest(myWest);
		assertEquals(true, room.getWest());
	}


}
