import org.junit.*;

import java.util.Arrays;

import static org.junit.Assert.*;


import java.util.List;

public class AnimalTest {


    @Test
    public void animal_instantiatesCorrectly_true() {
        Animal testAnimal = new Animal("Hare", "common");

        assertEquals(true, testAnimal instanceof Animal);
    }
}