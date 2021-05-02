import org.junit.*;

import java.util.Arrays;

import static org.junit.Assert.*;


import java.util.List;

public class AnimalTest {
    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void animal_instantiatesCorrectly_true() {
        Animal testAnimal = new Animal("Hare", "common");

        assertEquals(true, testAnimal instanceof Animal);
    }

    @Test
    public void getName_AnimalInstantiatesWithName_Hare() {
        Animal testAnimal = new Animal("Hare", "common");

        assertEquals("Hare", testAnimal.getName());
    }

    @Test
    public void getType_AnimalInstantiatesWithType_Common() {
        Animal testAnimal = new Animal("Hare", "common");
        assertEquals("common", testAnimal.getType());
    }
}