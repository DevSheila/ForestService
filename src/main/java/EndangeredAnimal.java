import org.sql2o.Connection;

import java.util.List;

public class EndangeredAnimal extends Animal implements DbManagement {

    public static final String ILL_HEALTH = "Ill";
    public static final String OKAY_HEALTH = "Okay";
    public static final String HEALTHY_HEALTH = "Healthy";

    public static final String NEWBORN_AGE = "Newborn";
    public static final String YOUNG_AGE = "Young";
    public static final String ADULT_AGE = "Adult";


    public EndangeredAnimal(String name, String type, String health, String age) {
        super(name, type);
        this.age = age;
        this.health = health;
        this.type = type;

    }
}