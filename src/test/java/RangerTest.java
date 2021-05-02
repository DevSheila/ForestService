import org.junit.*;

import java.util.Arrays;

import static org.junit.Assert.*;


import java.util.List;

public class RangerTest {
    @Rule
    public DatabaseRule database = new DatabaseRule();


    @Test
    public void Ranger_instantiatesCorrectly_true() {
        Ranger testRanger = new Ranger("Dennis", "6574", "28394835", "dennis@gmail.com");

        assertEquals(true, testRanger instanceof Ranger);
    }

    @Test
    public void getName_RangerInstantiatesWithName_Dennis() {
        Ranger testRanger = new Ranger("Dennis", "6574","28394835","dennis@gmail.com");

        assertEquals("Dennis", testRanger.getName());
    }
    @Test
    public void getBadgeNumber_RangerInstantiatesWithBadgeNumber_True() {
        Ranger testRanger = new Ranger("Dennis", "6574","28394835","dennis@gmail.com");

        assertEquals("6574", testRanger.getBadgeNumber());
    }
    @Test
    public void getPhoneNumber_RangerInstantiatesWithPhoneNumber_True() {
        Ranger testRanger = new Ranger("Dennis", "6574","28394835","dennis@gmail.com");

        assertEquals("28394835", testRanger.getPhoneNumber());
    }
    @Test
    public void getEmail_RangerInstantiatesWithEmail_True() {
        Ranger testRanger = new Ranger("Dennis", "6574","28394835","dennis@gmail.com");

        assertEquals("dennis@gmail.com", testRanger.getEmail());
    }

    @Test
    public void equals_returnsTrueIfInstancesSame_true() {
        Ranger testRanger = new Ranger("Dennis", "6574","28394835","dennis@gmail.com");
        Ranger anotherRanger = new Ranger("Dennis", "6574","28394835","dennis@gmail.com");

        assertTrue(testRanger.equals(anotherRanger));
    }
    @Test
    public void equals_returnsFalseIfInstances_false() {
        Ranger testRanger = new Ranger("Dennis", "6574","28394835","dennis@gmail.com");
        Ranger anotherRanger = new Ranger("Makaila", "7896","0710617457","makaila@gmail.com");
        assertFalse(testRanger.equals(anotherRanger));
    }


}