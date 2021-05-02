import org.sql2o.Connection;
import org.sql2o.Sql2oException;

import java.util.List;
import java.util.Objects;

public class Animal implements DbManagement {
    public int id;
    public String name;

    public String type;
    public String health;
    public String age;


    public Animal(String name, String type) {
        this.name = name;
        this.type = type;


    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getHealth() {
        return health;
    }

    public String getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Animal)) return false;
        Animal animal = (Animal) o;
        return Objects.equals(getName(), animal.getName()) && Objects.equals(getType(), animal.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getType());
    }


    @Override
    public void save() {

    }

    @Override
    public void update() {

    }
}