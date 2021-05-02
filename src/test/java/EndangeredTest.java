import org.junit.*;

import java.util.Arrays;

import static org.junit.Assert.*;


import java.util.List;

public class EndangeredTest {
    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void animal_instantiatesCorrectly_true() {
        EndangeredAnimal testAnimal = new EndangeredAnimal("Bonobo", "endangered", "ill", "adult");

        assertEquals(true, testAnimal instanceof Animal);
    }
}