import org.sql2o.Connection;
import org.sql2o.Sql2oException;

import java.util.List;
import java.util.Objects;

public class Animal {
    public int id;
    public String name;

    public String type;
    public String health;
    public String age;


    public Animal(String name, String type) {
        this.name = name;
        this.type = type;


    }
}