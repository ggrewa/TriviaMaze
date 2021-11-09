package programs;

import java.util.Objects;

public class Door {
        /** This boolean expression checks whether the door is locked.**/
        private boolean myDoorLocked = false;
        

        /**The question correlated with the door.*/
        private Question myQuestion;
        /** This boolean expression will make sure the user is in the boundaries. */
        private boolean myWall;
        /**
         * The door is unlocked.
         */
        public void unLockDoor() {
            myDoorLocked = true;
        }
        /**
         * Tells the user whether the door is locked or unlocked. 
         */
        @Override 
        public String toString() {
                String key;
                if(myDoorLocked = false) {
                        key = "The Door is Locked";
                } else {
                        key = "The Door has opened!";
                }
                return key;
        }
        public Question getQuestion() {
            return myQuestion;
        }
        
        public boolean isDoorLocked() {
            return myDoorLocked;
        }
        
        public boolean getWall() {
            return myWall;
        }
        
}
