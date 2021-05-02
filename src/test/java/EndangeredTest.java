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

    @Test
    public void getName_AnimalInstantiatesWithName_Bonobo() {
        EndangeredAnimal testAnimal = new EndangeredAnimal("Bonobo", "endangered","ill","adult");
        assertEquals("Bonobo", testAnimal.getName());
    }
    @Test
    public void getType_AnimalInstantiatesWithType_Common() {
        EndangeredAnimal testAnimal = new EndangeredAnimal("Bonobo", "endangered","ill","adult");
        assertEquals("endangered", testAnimal.getType());
    }
    @Test
    public void getHealth_AnimalInstantiatesWithHealth_Ill() {
        EndangeredAnimal testAnimal = new EndangeredAnimal("Bonobo", "endangered","ill","adult");
        assertEquals("ill", testAnimal.getHealth());
    }
    @Test
    public void getAge_AnimalInstantiatesWithAge_Adult() {
        EndangeredAnimal testAnimal = new EndangeredAnimal("Bonobo", "endangered","ill","adult");
        assertEquals("adult", testAnimal.getAge());
    }
    @Test
    public void equals_returnsTrueIfNameAndTypeAreSame_true() {
        EndangeredAnimal testAnimal = new EndangeredAnimal("Bonobo", "endangered","ill","adult");
        EndangeredAnimal anotherAnimal = new EndangeredAnimal("Saola", "endangered","ill","adult");

        assertTrue(testAnimal.equals(anotherAnimal));
    }
    @Test
    public void equals_returnsFalseIfNameAndTypeAreDifferent_false() {
        EndangeredAnimal testAnimal = new EndangeredAnimal("Bonobo", "endangered","ill","adult");
        EndangeredAnimal anotherAnimal = new EndangeredAnimal("Saola", "endangered","ill","adult");
        assertFalse(testAnimal.equals(anotherAnimal));
    }
}