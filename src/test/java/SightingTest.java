import org.junit.*;

import java.util.Arrays;

import static org.junit.Assert.*;


import java.util.List;

public class SightingTest {
    @Rule
    public DatabaseRule database = new DatabaseRule();


    @Test
    public void sighting_instantiatesCorrectly_true() {
        Sighting testSighting = new Sighting("Tiger", "Zone 12", 4567);

        assertEquals(true, testSighting instanceof Sighting);
    }

    @Test
    public void getAnimalName_SightingInstantiatesWithName_Dennis() {
        Animal testAnimal = new Animal("Tiger", "common");
        Sighting testSighting= new Sighting(testAnimal.getName(), "Zone 12",4567);

        assertEquals("Tiger", testSighting.getAnimalName());
    }


    @Test
    public void getLocation_SightingInstantiatesWithLocation_True() {
        Sighting testSighting= new Sighting("Tiger", "Zone 12",4567);


        assertEquals("Zone 12", testSighting.getLocation());
    }
    @Test
    public void getRangerId_SightingInstantiatesWithRangerId_True() {
        Ranger testRanger = new Ranger("Makaila", "7896","0710617457","makaila@gmail.com");
        Sighting testSighting= new Sighting("Tiger", "Zone 12",testRanger.getId());


        assertEquals(testRanger.getId(), testSighting.getRangerId());
    }

}