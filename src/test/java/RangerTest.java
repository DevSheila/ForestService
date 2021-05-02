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
}