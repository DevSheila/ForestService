import org.sql2o.Connection;

import java.util.List;
import java.util.Objects;

public class Ranger implements DbManagement {
    private int id;
    private String name;
    private String badge_number;
    private String phone_number;
    private String email;

    public Ranger(String name, String badge_number, String phone_number, String email) {
        this.name = name;
        this.badge_number = badge_number;
        this.phone_number = phone_number;
        this.email = email;
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBadgeNumber() {
        return badge_number;
    }

    public String getPhoneNumber() {
        return phone_number;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public void save() {

    }

    @Override
    public void update() {

    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ranger)) return false;
        Ranger ranger = (Ranger) o;
        return Objects.equals(getBadgeNumber(), ranger.getBadgeNumber()) && Objects.equals(getEmail(), ranger.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBadgeNumber(), getEmail());
    }
}
